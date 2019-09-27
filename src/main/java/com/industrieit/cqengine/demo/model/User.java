package com.industrieit.cqengine.demo.model;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

public class User {
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String profession;

    public User(String userName, String email, String firstName, String lastName, String profession) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    public static final Attribute<User, String> USER_NAME = new SimpleAttribute<User, String>() {
        @Override
        public String getValue(User user, QueryOptions queryOptions) {
            return user.getUserName();
        }

    };
    public static final Attribute<User, String> PROFESSION = new SimpleAttribute<User, String>() {
        @Override
        public String getValue(User user, QueryOptions queryOptions) {
            return user.getProfession();
        }
    };
    public static final Attribute<User, String> EMAIL = new SimpleAttribute<User, String>() {
        @Override
        public String getValue(User user, QueryOptions queryOptions) {
            return user.getEmail();
        }
    };
    public static final Attribute<User, String> FISRT_NAME = new SimpleAttribute<User, String>() {
        @Override
        public String getValue(User user, QueryOptions queryOptions) {
            return user.getFirstName();
        }
    };
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfession() {
        return profession;
    }
}
