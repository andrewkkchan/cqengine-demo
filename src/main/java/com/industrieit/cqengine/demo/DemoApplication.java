package com.industrieit.cqengine.demo;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.resultset.ResultSet;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import com.industrieit.cqengine.demo.factory.CarFactory;
import com.industrieit.cqengine.demo.model.Car;
import com.industrieit.cqengine.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static com.googlecode.cqengine.query.QueryFactory.endsWith;
import static com.googlecode.cqengine.query.QueryFactory.equal;
import static com.googlecode.cqengine.query.QueryFactory.lessThan;
import static com.sun.tools.doclint.Entity.or;

@SpringBootApplication
public class DemoApplication {

    private static final int COLLECTION_SIZE = 10000;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        IndexedCollection<User> indexedUsers = new ConcurrentIndexedCollection<>();
        indexedUsers.addIndex(HashIndex.onAttribute(User.USER_NAME));
        indexedUsers.add(new User("andrewkkchan", "andrewchan@example.com", "Andrew", "Chan", "Accountant"));
        indexedUsers.add(new User("andrewwong", "andrewong@example.com", "Andrew", "Wong", "Programmer"));
        indexedUsers.add(new User("amywong", "amywong@example.com", "Amy", "Wong", "Accountant"));


        ResultSet<User> accountants = indexedUsers.retrieve(equal(User.PROFESSION, "Accountant"));
        for (User user : accountants){
            System.out.println(user);
        }
        Collection<Car> cars = CarFactory.createCollectionOfCars(COLLECTION_SIZE);
        IndexedCollection<Car> indexedCars = new ConcurrentIndexedCollection<>();
        indexedCars.addIndex(HashIndex.onAttribute(Car.COLOR));
        indexedCars.addAll(cars);
        ResultSet<Car> blackCars = indexedCars.retrieve(equal(Car.COLOR, Car.Color.BLACK));
        System.out.println("We found number of black car : "+ blackCars.size());

        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
        Map<Long, String> map = hzInstance.getMap("data");
        IdGenerator idGenerator = hzInstance.getIdGenerator("newid");
        for (int i = 0; i < 10; i++) {
            map.put(idGenerator.newId(), "message" + 1);
        }

    }

}
