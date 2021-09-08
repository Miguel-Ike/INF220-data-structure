/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.tda_dynamic.simple.generic.node;

/**
 *
 * @author Miguel_Ike
 * @param <Var>
 */
public class Node<Var> {

    private Var data;
    private Node link;

    public Node() {
        this.data = null;
        this.link = null;
    }

    public Node(Var data) {
        this.data = data;
        this.link = null;
    }

    public Node(Var data, Node link) {
        this.data = data;
        this.link = link;
    }

    public Var getData() {
        return data;
    }

    public void setData(Var data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
