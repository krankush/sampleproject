package com.ankush.sampleproject.dao;


import com.ankush.sampleproject.entity.Employee;
import com.ankush.sampleproject.mapper.EmployeeMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;
@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDao{
    @SqlQuery("select * from employee;")
    List<Employee> getEmployees();
}

