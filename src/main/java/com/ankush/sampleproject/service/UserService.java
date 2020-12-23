package com.ankush.sampleproject.service;

import com.ankush.sampleproject.dao.UserDao;
import com.ankush.sampleproject.entity.User;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class UserService {

    @CreateSqlObject
    abstract UserDao getUserDao();

    public int registerUser(User user){
        return getUserDao().createUser(user.name, user.email, user.password);
    }
}