package com.imipgroup.hieuvt.xmlconfig;

/**
 * Created by Administrator on 10/15/2014.
 */
public class Employee {

    private int id;
    private String name;

    public Employee(){

    }
    public Employee(String name){
        setName(name);
    }
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
}
