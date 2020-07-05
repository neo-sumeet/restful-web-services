package com.ss.restfulwebservices.responseFiltering.dynamicFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("StudentDynamicFilter")
public class Student {
    private int id;
    private String name;
    private String email;
    private Parent parent;
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

    public Student(int id, String name, String email, Parent parent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.parent = parent;
    }

    public Student() {
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
