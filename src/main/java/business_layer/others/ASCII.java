/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.others;

/**
 *
 * @author Miguel_Ike
 */
public class ASCII {

    private final String ALPHABET = " -.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_Ñ";

    /**
     *
     * @param c
     * @return -1 si no pertenece al alfabeto
     */
    public int transformToInteger(char c) {
        return ALPHABET.indexOf(c);
    }

    public char transformToString(int value) {
        return ALPHABET.charAt(value);
    }

    public void print() {
        System.out.println(ALPHABET.length());
        for (int i = 0; i < ALPHABET.length(); i++) {
            System.out.println(ALPHABET.charAt(i) + " : " + (int) ALPHABET.charAt(i));
        }
    }
}
