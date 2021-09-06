/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.simple.generic.queue;

/**
 *
 * @author Miguel_Ike
 * @param <Var>
 */
public class Queue<Var> {

    private Node<Var> front;
    private Node<Var> rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public Queue(Var data) {
        this.front = new Node<>(data);
        this.rear = this.front;
        this.size = 1;
    }

    public Node<Var> getFront() {
        return front;
    }

    public void setFront(Node<Var> front) {
        this.front = front;
    }

    public Node<Var> getRear() {
        return rear;
    }

    public void setRear(Node<Var> rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0 && this.front == null && this.rear == null;
    }

    public void enqueue(Var data) {
        if (isEmpty()) {
            this.front = this.rear = new Node<>(data);
            this.size = 1;
        } else {
            Node<Var> newNode = new Node(data);
            this.rear.setLink(newNode);
            this.rear = newNode;
            this.size++;
        }
    }

    public Var dequeue() {
        Var data = null;
        if (!isEmpty()) {
            if (getSize() == 1 && this.front != null) {
                data = this.front.getData();
                this.front = this.rear = null;
                this.size = 0;
            } else {
                data = this.front.getData();
                this.front = this.front.getLink();
                this.size--;
            }
        }
        return data;
    }

    @Override
    public String toString() {
        return isEmpty() ? "Queue { NULL }" : String.format("Queue {\n%s\n}", toStringValues());
    }

    private String toStringValues() {
        String s = "";
        for (int i = 0; i < getSize(); i++) {
            Var data = dequeue();
            s += String.format("\nIndex: %d\n", i) + data.toString();
            enqueue(data);
        }
        return s;
    }

}
