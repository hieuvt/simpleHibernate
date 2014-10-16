package com.imipgroup.hieuvt.xmlconfig;

import java.util.Set;

/**
 * Created by Administrator on 10/15/2014.
 */
public class Employee {

    private int id;
    private String name;
    private Set<Certificate> certificates;

    public Employee(){

    }
    public Employee(String name){
        setName(name);
    }

    public Employee(String name, Set<Certificate> certificates){
        setName(name);
        setCertificates(certificates);
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

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }
}
