package com.industrieit.cqengine.demo.factory;

import com.industrieit.cqengine.demo.model.Car;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class CarFactory {
    public static Set<Car> createCollectionOfCars(int numCars) {
        Set<Car> cars = new LinkedHashSet<Car>(numCars);
        for (int carId = 0; carId < numCars; carId++) {
            cars.add(createCar(carId));
        }
        return cars;
    }

    public static Car createCar(int carId) {
        switch (carId % 10) {
            case 0: return new Car(carId, "Ford",   "Focus",   Car.Color.RED,   5, 5000.00, noFeatures());
            case 1: return new Car(carId, "Ford",   "Fusion",  Car.Color.RED,   4, 3999.99, asList("hybrid"));
            case 2: return new Car(carId, "Ford",   "Taurus",  Car.Color.GREEN, 4, 6000.00, asList("grade a"));
            case 3: return new Car(carId, "Honda",  "Civic",   Car.Color.WHITE, 5, 4000.00, asList("grade b"));
            case 4: return new Car(carId, "Honda",  "Accord",  Car.Color.BLACK, 5, 3000.00, asList("grade c"));
            case 5: return new Car(carId, "Honda",  "Insight", Car.Color.GREEN, 3, 5000.00, noFeatures());
            case 6: return new Car(carId, "Toyota", "Avensis", Car.Color.GREEN, 5, 5999.95, noFeatures());
            case 7: return new Car(carId, "Toyota", "Prius",   Car.Color.BLUE,  3, 8500.00, asList("sunroof", "hybrid"));
            case 8: return new Car(carId, "Toyota", "Hilux",   Car.Color.RED,   5, 7800.55, noFeatures());
            case 9: return new Car(carId, "BMW",    "M6",      Car.Color.BLUE,  2, 9000.23, asList("coupe"));
            default: throw new IllegalStateException();
        }
    }

    static List<String> noFeatures() {
        return Collections.<String>emptyList();
    }
}
