/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.simple.generic.stack;

import business_layer.simple.generic.node.Node;

/**
 *
 * @author Miguel_Ike
 * @param <Var>
 */
public class Stack<Var> {

    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0 && this.top == null;
    }

    public void push(Var data) {
        if (isEmpty()) {
            this.top = new Node(data);
            this.size++;
        } else {
            Node<Var> newNode = new Node<>(data, this.top);
            this.top = newNode;
            this.size++;
        }
    }

    public Var pop() {
        if (isEmpty()) {
            return null;
        } else {
            Var data = (Var) this.top.getData();
            this.top = this.top.getLink();
            this.size--;
            return data;
        }
    }

    public Var peek() {
        return isEmpty() ? null : (Var) this.top.getData();
    }

    @Override
    public String toString() {
        return isEmpty() ? "Stack { NULL }" : String.format("Stack {\n%s\n}", toStringValues(getSize()));
    }

    private String toStringValues(int index) {
        String s = "";
        if (!isEmpty()) {
            Var data = pop();
            s += String.format("\nIndex: %d\n", index) + data.toString() + toStringValues(index - 1);
            push(data);
        }
        return s;
    }

}
