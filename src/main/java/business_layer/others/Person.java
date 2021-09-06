/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_layer.others;

import java.time.LocalDate;

/**
 *
 * @author Miguel_Ike
 */
public class Person implements Comparable {

    private Integer dni;
    private String name;
    private String lastname;
    private LocalDate date;

    public Person(Integer dni, String name, String lastname, LocalDate date) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.date = date;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String format = "\tDNI: %d\n"
                + "\tName: %s\n"
                + "\tLastName: %s\n"
                + "\tDate: %s\n";
        String sDate = this.date.getDayOfWeek() + " "
                + String.valueOf(this.date.getDayOfMonth()) + " "
                + this.date.getMonth() + " "
                + this.date.getYear();
        return String.format(format, this.dni, this.name, this.lastname, sDate);
    }

    @Override
    public int compareTo(Object object) {
        Person person = (Person) object;
        return getDni() < person.getDni() ? -1 : getDni() > person.getDni() ? 1 : 0;
    }

}
