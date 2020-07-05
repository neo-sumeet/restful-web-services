package com.ss.restfulwebservices.responseFiltering.dynamicFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("ParentFilter")
public class Parent {
    private int id;
    private String name;

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

    public Parent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Parent() {
    }
}

