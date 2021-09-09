/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.tda_static.bitwise_generic;

/**
 *
 * @author Miguel_Ike
 */
public class Bitwise {

    private int array[];
    private final int qtty_bits; //quantity
    private int qtty_element; //quantity
    private int size;

    /**
     *
     * @param qtty_element
     * @param qtty_bits
     */
    public Bitwise(int qtty_element, int qtty_bits) {
        this.qtty_element = qtty_element;
        this.qtty_bits = qtty_bits;
        this.array = new int[qtty_int(qtty_element, qtty_bits)];
        this.size = 0;
    }

    private int qtty_int(int qtty_element, int qtty_bits) {
        int int_qtty = (qtty_element * qtty_bits) / 32;
        if (((qtty_element * qtty_bits) % 32) != 0) {
            int_qtty++;
        }
        return int_qtty;
    }

    /**
     *
     * @return la cantidad de elementos en el bitwise
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.qtty_element;
    }

    private int integerPosition(int index) {
        return ((index) * this.qtty_bits) / 32;
    }

    private int bitPosition(int index) {
        return ((index) * this.qtty_bits) % 32;
    }

    private boolean validateValue(int value) {
        return value >= 0 && value <= Math.pow(2, this.qtty_bits) - 1;
    }

    private boolean validatePosition(int index) {
        return index >= 0 && index < this.size;
    }

    /**
     *
     * @param value
     */
    public void add(int value) {
        if (validateValue(value)) {
            if (!isFull()) {
                int value1 = value;
                int bp = bitPosition(this.size);
                int ip = integerPosition(this.size);
                int mask = ~(((int) Math.pow(2, this.qtty_bits) - 1) << bp);
                array[ip] = (array[ip] & mask) | (value << bp);

                if (bp + this.qtty_bits > 32) {
                    mask = ((int) Math.pow(2, this.qtty_bits) - 1) >>> (32 - bp);
                    array[ip + 1] = (array[ip + 1] & ~mask) | (value1 >>> (32 - bp));
                }
                this.size++;
            } else {
                System.out.println("Error-> Bitwise lleno...");
            }
        } else {
            System.out.println("Error-> Valor ocupa mucho mas bits o esta fuera de rango...");
        }
    }

    /**
     *
     * @param value
     * @param index {0 ... size-1}
     * @return false si el index esta fuera de rango
     */
    public boolean set(int value, int index) {
        return validatePosition(index) ? setValue(value, index) : false;
    }

    private boolean setValue(int value, int index) {
        int value1 = value;
        int bp = bitPosition(index);
        int ip = integerPosition(index);
        int mask = ~(((int) Math.pow(2, this.qtty_bits) - 1) << bp);
        array[ip] = (array[ip] & mask) | (value << bp);
//        System.out.println("bit: " + bp + " Int: " + ip);
        if (bp + this.qtty_bits > 32) {
            mask = ((int) Math.pow(2, this.qtty_bits) - 1) >>> (32 - bp);
            array[ip + 1] = (array[ip + 1] & ~mask) | (value1 >>> (32 - bp));
        }
        return true;
    }

    /**
     *
     * @param index {0 ... size-1}
     * @return null si index esta fuera de rango
     */
    public Integer get(int index) {
        return validatePosition(index) ? getValue(index) : null;
    }

    private Integer getValue(int index) {
        int bp = bitPosition(index);
        int ip = integerPosition(index);
        int mask = (int) Math.pow(2, this.qtty_bits) - 1;
        Integer value = array[ip] >>> bp;
        if (bp + this.qtty_bits > 32) {
            value = value | (array[ip + 1] << (32 - bp));
        }
        value = value & mask;
        return value;
    }

    /**
     *
     * @param value
     * @param index {0 ... size}
     * @return false si el index esta fuera de rango
     */
    public boolean insert(int value, int index) {
        System.out.println(getSize());
        System.out.println(index);
        return (index >= 0 && index <= this.size && index + 1 <= this.qtty_element) ? insertValue(value, index) : false;
    }

    private boolean insertValue(int value, int index) {
        System.out.println("aqui");
        this.size++;
        for (int i = getSize(); i > index; i--) {
            setValue(get(i - 1), i);
        }
        set(value, index);
        return true;
    }

    /**
     *
     * @param index {0 ... size-1}
     * @return false si el index esta fuera de rango
     */
    public boolean remove(int index) {
        return validatePosition(index) ? removeValue(index) : false;
    }

    private boolean removeValue(int index) {
        if (getSize() >= 1) {
            for (int i = index; i < this.size - 1; i++) {
                set(get(i + 1), i);
            }
        }
        this.size--;
        return true;
    }

    @Override
    public String toString() {
        return isEmpty() ? "Bitwise { NULL }" : String.format("Bitwise { %s }", toStringValues());
    }

    private String toStringValues() {
        String s = "";
        for (int i = 0; i < getSize(); i++) {
            s += get(i) + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

    public void expandArrangement() {
        this.qtty_element = (int) (this.qtty_element * 1.25);
        int array0[] = new int[this.qtty_element];
        System.arraycopy(array, 0, array0, 0, array.length);
        this.array = array0;
    }

}
