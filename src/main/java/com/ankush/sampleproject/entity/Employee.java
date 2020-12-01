package com.ankush.sampleproject.entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = -1870736230296690961L;
    public Integer id;
    public String name;
    public Employee(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString(){
        return "Employee{"+
                "id="+id+
                ", name='"+name+
                '}';
    }
}
