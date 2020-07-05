package com.ss.restfulwebservices.responseFiltering.staticFiltering;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
    private int id;
    private String name;

    // static filtering - this element will never be sent out in any response using this model
    @JsonIgnore
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student() {
    }
}
