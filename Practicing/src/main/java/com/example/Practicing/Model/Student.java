package com.example.Practicing.Model;


public class Student {
    protected String name;
    protected int id;

    public Student(){}
    public Student (int id, String name) {
        this.name= name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
