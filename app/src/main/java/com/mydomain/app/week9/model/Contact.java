package com.mydomain.app.week9.model;

public class Contact {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Contact(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEmail() {
        return age;
    }

    public double getPhone() {
        return salary;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(int age){
        this.age = age;
    }

    public void setPhone(double salary){
        this.salary = salary;
    }
}
