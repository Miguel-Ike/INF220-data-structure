/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import business_layer.others.Person;
import business_layer.simple.generic.lists.List;
import java.time.LocalDate;
import java.time.Month;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Test test = new Test();
        test.testList();
    }

}
