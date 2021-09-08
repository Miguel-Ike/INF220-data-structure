/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.tda_dynamic.simple.generic.list;

import business_layer.tda_dynamic.simple.generic.node.Node;

/**
 *
 * @author Miguel_Ike
 * @param <Var>
 */
public class List<Var extends Comparable> {

    private Node<Var> list;
    private int size;

    public List() {
        this.list = null;
        this.size = 0;
    }

    public Node<Var> getList() {
        return list;
    }

    public void setList(Node<Var> list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0 && this.list == null;
    }

    /**
     *
     * @param data
     */
    public void add(Var data) {

        if (isEmpty()) {
            this.list = new Node<>(data);
            this.size++;
        } else {
            Node<Var> p0 = null;
            Node<Var> p1 = this.list;

            while (p1 != null && p1.getData().compareTo(data) < 0) {
                p0 = p1;
                p1 = p1.getLink();
            }

            Node<Var> newNode = new Node<>(data);
            if (p0 == null) {
                newNode.setLink(this.list);
                this.list = newNode;
            } else {
                p0.setLink(newNode);
                newNode.setLink(p1);
            }
            this.size++;
        }
    }

    /**
     *
     * @param data
     * @param index {0 ... size-1}
     */
    public void add(Var data, int index) {

        if (isEmpty()) {
            this.list = new Node<>(data);
            this.size++;
        } else {
            Node<Var> p0 = null;
            Node<Var> p1 = this.list;

            if (index >= 0 && index <= this.size) {
                for (int i = 0; i < index; i++) {
                    p0 = p1;
                    p1 = p1.getLink();
                }

                Node<Var> newNode = new Node<>(data);
                if (p0 == null) {
                    newNode.setLink(this.list);
                    this.list = newNode;
                } else {
                    p0.setLink(newNode);
                    newNode.setLink(p1);
                }
                this.size++;
            } else {
                System.out.println("index out of range {0 ... size-1}");
            }

        }
    }

    /**
     *
     * @param index {0 ... size-1}
     * @return null si esta vacia o el indice esta fuera de rango
     */
    public Var get(int index) {
        return isEmpty() ? null : (index < 0 || index >= this.size) ? null : getElement(index);
    }

    private Var getElement(int index) {
        Node<Var> p = this.list;
        for (int i = 0; i < index; i++) {
            p = p.getLink();
        }
        return p.getData();
    }

    /**
     *
     * @param index {0 ... size-1}
     * @return false si esta vacia la lista o el indice esta fuera de rango
     */
    public boolean remove(int index) {
        return isEmpty() ? false : (index < 0 || index >= this.size) ? false : removeElement(index);
    }

    private boolean removeElement(int index) {
        Node<Var> p0 = null;
        Node<Var> p1 = this.list;
        for (int i = 0; i < index; i++) {
            p0 = p1;
            p1 = p1.getLink();
        }

        if (p0 == null) {
            this.list = this.list.getLink();
        } else {
            p0.setLink(p1.getLink());
        }
        this.size--;
        return false;
    }

    @Override
    public String toString() {
        return isEmpty() ? "List { NULL }" : String.format("List {\n%s\n}", toStringValues());
    }

    private String toStringValues() {
        String values = "";
        Node<Var> p = this.list;
        for (int i = 0; i < getSize(); i++) {
            values += String.format("\nIndex: %d\n", i) + p.getData();
            p = p.getLink();
        }
        return values;
    }

}
