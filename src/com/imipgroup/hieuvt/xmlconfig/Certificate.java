package com.imipgroup.hieuvt.xmlconfig;

/**
 * Created by Administrator on 10/16/2014.
 */
public class Certificate {
    private int id;
    private String certificateName;
    private int employeeId;

    public Certificate(){

    }

    public Certificate(String name){
        setCertificateName(name);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
