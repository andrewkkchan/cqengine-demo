package com.industrieit.cqengine.demo.model;

import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;

import java.util.List;

public class Car {
    public static final SimpleAttribute<Car, Integer> CAR_ID = new SimpleAttribute<Car, Integer>("carId") {
        public Integer getValue(Car car, QueryOptions queryOptions) { return car.carId; }
    };

    public static final SimpleAttribute<Car, String> MANUFACTURER = new SimpleAttribute<Car, String>("manufacturer") {
        public String getValue(Car car, QueryOptions queryOptions) { return car.manufacturer; }
    };

    public static final SimpleAttribute<Car, String> MODEL = new SimpleAttribute<Car, String>("model") {
        public String getValue(Car car, QueryOptions queryOptions) { return car.model; }
    };

    public static final SimpleAttribute<Car, Color> COLOR = new SimpleAttribute<Car, Color>("color") {
        public Color getValue(Car car, QueryOptions queryOptions) { return car.color; }
    };

    public static final SimpleAttribute<Car, Integer> DOORS = new SimpleAttribute<Car, Integer>("doors") {
        public Integer getValue(Car car, QueryOptions queryOptions) { return car.doors; }
    };

    public static final SimpleAttribute<Car, Double> PRICE = new SimpleAttribute<Car, Double>("price") {
        public Double getValue(Car car, QueryOptions queryOptions) { return car.price; }
    };

    public static final MultiValueAttribute<Car, String> FEATURES = new MultiValueAttribute<Car, String>("features") {
        public Iterable<String> getValues(Car car, QueryOptions queryOptions) { return car.features; }
    };

    public enum Color {RED, GREEN, BLUE, BLACK, WHITE}
    final int carId;
    final String manufacturer;
    final String model;
    final Color color;
    final int doors;
    final double price;
    final List<String> features;

    public Car(int carId, String manufacturer, String model, Color color, int doors, double price, List<String> features) {
        this.carId = carId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.doors = doors;
        this.price = price;
        this.features = features;
    }

    public int getCarId() {
        return carId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", doors=" + doors +
                ", price=" + price +
                ", features=" + features +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return carId;
    }
}
