package com.ankush.sampleproject.service;

import com.ankush.sampleproject.dao.EmployeeDao;
import com.ankush.sampleproject.entity.Employee;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class EmployeeService {

    @CreateSqlObject
    abstract EmployeeDao getEmployeeDao();

    public List<Employee> getAllEmployees(){
        return getEmployeeDao().getEmployees();
    }
}
