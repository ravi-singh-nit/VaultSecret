package com.sammu.learning.springbootDemo.models;

public class Employee {
    String eName;
    int eId;
    String eProject;
    public int eSalary;
    public Employee(String name, int id, String project,int salary){
        this.eName = name;
        this.eId = id;
        this.eProject = project;
        this.eSalary=salary;
    }
    public String toString(){
        return eName+" "+eSalary;
    }
}
