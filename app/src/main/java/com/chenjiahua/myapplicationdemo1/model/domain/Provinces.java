package com.chenjiahua.myapplicationdemo1.model.domain;

public class Provinces {


    /**
     * id : 1
     * name : 北京
     */

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

    @Override
    public String toString() {
        return "Provinces{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
