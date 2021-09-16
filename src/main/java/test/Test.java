/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import business_layer.others.ASCII;
import business_layer.others.Person;
import business_layer.tda_dynamic.simple.generic.list.List;
import business_layer.tda_dynamic.simple.generic.queue.Queue;
import business_layer.tda_dynamic.simple.generic.stack.Stack;
import business_layer.tda_static.bitwise_generic.Bitwise;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

/**
 *
 * @author Miguel_Ike
 */
public class Test {

    public void testList() {
        List<Person> list = new List<>();
        System.out.println(list);
        list.add(new Person(9791996, "Miguel", "Martinez", LocalDate.of(1995, Month.SEPTEMBER, 3)));
        list.add(new Person(9691996, "Katherine", "Valverde", LocalDate.of(1995, Month.SEPTEMBER, 8)));
        list.add(new Person(9891996, "Johana", "Huiza", LocalDate.of(1995, Month.SEPTEMBER, 4)));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list);
        list.add(new Person(9891996, "Johana1", "Huiza", LocalDate.of(1995, Month.SEPTEMBER, 4)), 0);
        list.add(new Person(9891996, "Johana2", "Huiza", LocalDate.of(1995, Month.SEPTEMBER, 4)), 2);
        list.add(new Person(9891996, "Johana3", "Huiza", LocalDate.of(1995, Month.SEPTEMBER, 4)), 5);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
    }

    public void testQueue() {
        Queue<Person> queue = new Queue<>();
        System.out.println(queue);
        queue.enqueue(new Person(9791996, "Miguel", "Martinez", LocalDate.of(1995, Month.SEPTEMBER, 3)));
        queue.enqueue(new Person(9691996, "Katherine", "Valverde", LocalDate.of(1995, Month.SEPTEMBER, 8)));
        queue.enqueue(new Person(9891996, "Johana", "Huiza", LocalDate.of(1995, Month.SEPTEMBER, 4)));
        System.out.println(queue);
        System.out.println(queue);
    }

    public void testStack() {
        Stack<Person> stack = new Stack<>();
        System.out.println(stack);
        stack.push(new Person(9791996, "Miguel", "Martinez", LocalDate.of(1995, Month.SEPTEMBER, 3)));
        stack.push(new Person(9691996, "Katherine", "Valverde", LocalDate.of(1995, Month.SEPTEMBER, 8)));
        stack.push(new Person(9891996, "Johana", "Huiza", LocalDate.of(1995, Month.SEPTEMBER, 4)));
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    public void testBitwise() {
        Bitwise b = new Bitwise(6, 6);
        for (int i = 0; i < 5; i++) {
            int value = (int) (Math.random() * 60 + 1);
            b.add(value);
            System.out.println("Se agrego: " + value);
        }
        System.out.println(b);
        System.out.println(b.set(48, 2));
        System.out.println(b.set(49, 4));

        System.out.println(b);
        b.remove(0);
        System.out.println(b);
        b.remove(3);
        System.out.println(b);
        b.remove(1);
        System.out.println(b);
        b.insert(45, 0);
        System.out.println(b);
        b.insert(46, 1);
        System.out.println(b);
        b.insert(47, 3);
        System.out.println(b);
        b.insert(48, 5);
        System.out.println(b);
        b.expandArrangement();
        b.add(63);
        System.out.println(b);

    }

    public void testASCII() {
        ASCII ascii = new ASCII();
//        ascii.print();

        System.out.println(ascii.transformToInteger('A'));
        System.out.println(ascii.transformToChar(13));
        System.out.println(ascii.transformToInteger(' '));
        System.out.println(ascii.transformToInteger('0'));
        System.out.println(ascii.transformToInteger('A'));
        System.out.println(ascii.transformToInteger('Ñ'));
        int s[] = ascii.transformToString(".ABCDEñ");
        System.out.println(Arrays.toString(s));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Test test = new Test();
//        test.testList();
//        test.testQueue();
//        test.testStack();
//        test.testBitwise();
        test.testASCII();

    }

}
