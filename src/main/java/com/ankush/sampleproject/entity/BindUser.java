package com.ankush.sampleproject.entity;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import org.jdbi.v3.sqlobject.customizer.SqlStatementCustomizerFactory;
import org.jdbi.v3.sqlobject.customizer.SqlStatementCustomizingAnnotation;
import org.jdbi.v3.sqlobject.customizer.SqlStatementParameterCustomizer;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@SqlStatementCustomizingAnnotation(BindUser.Factory.class)
public @interface BindUser {
    class Factory implements SqlStatementCustomizerFactory {

        @Override
        public SqlStatementParameterCustomizer createForParameter(
                Annotation annotation,
                Class<?> sqlObjectType,
                Method method,
                Parameter param,
                int index,
                Type type) {

            return (q, arg) -> {
                User user = (User) arg;

                q.bind("name", user.name);
                q.bind("email", user.email);
                q.bind("password", user.password);
            };
        }
    }
}
