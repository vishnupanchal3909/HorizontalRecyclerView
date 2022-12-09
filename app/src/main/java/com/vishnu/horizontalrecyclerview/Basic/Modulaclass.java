package com.vishnu.horizontalrecyclerview.Basic;

import android.telecom.StatusHints;

public class Modulaclass {

    int  id,age,salary;
    String  firstName,lastName,email;

    public Modulaclass(int id, int age, int salary, String firstName, String lastName, String email) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public Modulaclass(String name){
        this.firstName= name;
    }

    public String toString(){
        return firstName;
    }

}
