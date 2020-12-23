package com.ankush.sampleproject.dao;
import com.ankush.sampleproject.entity.BindUser;
import com.ankush.sampleproject.entity.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDao {

    @SqlUpdate("insert into user (name, email_id, password) values ( :name , :email , :password)")
    int createUser(@Bind("name") String name, @Bind("email") String email, @Bind("password") String password);
}
