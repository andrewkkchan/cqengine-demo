package com.industrieit.cqengine.demo;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;
import com.industrieit.cqengine.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.googlecode.cqengine.query.QueryFactory.endsWith;
import static com.googlecode.cqengine.query.QueryFactory.equal;
import static com.googlecode.cqengine.query.QueryFactory.lessThan;
import static com.sun.tools.doclint.Entity.or;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        IndexedCollection<User> indexedUsers = new ConcurrentIndexedCollection<>();
        indexedUsers.addIndex(HashIndex.onAttribute(User.USER_NAME));
        indexedUsers.add(new User("andrewkkchan", "andrewchan@example.com", "Andrew", "Chan", "Accountant"));
        ResultSet<User> accountant = indexedUsers.retrieve(equal(User.PROFESSION, "Accountant"));
        for (User user : accountant){
            System.out.println(user);
        }
    }

}
