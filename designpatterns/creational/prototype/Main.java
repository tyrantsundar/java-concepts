package designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
/*
   1. Explain Prototype Design pattern in brief.
    Ans. Prototype Design pattern provides us a way to create new objects
    by using existing objects. In other words, we can copy data from the existing
    object and store it in our new object by using this pattern.

  2.  Explain Shallow Copy and Deep Copy in Prototype Design patterns.
    Ans. Shallow Copy and Deep Copy are types of cloning in Prototype Design patterns.
    In shallow copy, we only cloned the parent object and not its containing objects
    while in deep copy, we cloned the parent object as well as its containing objects.
*/
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.noOfTyre = 2;
        bike.colour = "red";
        bike.noOfSeat = 3;

        Car car = new Car();
        car.colour = "orange";
        car.noOfSeat = 4;
        car.noOfTyre = 5;

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(bike);
        vehicleList.add(car);

        List<Vehicle> vehicleProtoTypes = new ArrayList<>();
        vehicleProtoTypes.add(bike.clone());
        vehicleProtoTypes.add(car.clone());

        System.out.println("Before Change");
        System.out.println("Original");
        for(Vehicle vehicle : vehicleList){
            System.out.println(vehicle.toString());
        }
        System.out.println("Prototypes");
        for(Vehicle vehicle : vehicleProtoTypes){
            System.out.println(vehicle.toString());
        }

        car.noOfTyre = 10;
        bike.colour = "Yellow";
        System.out.println("After Change");
        System.out.println("Original");
        for(Vehicle vehicle : vehicleList){
            System.out.println(vehicle.toString());
        }
        System.out.println("Prototypes");
        for(Vehicle vehicle : vehicleProtoTypes){
            System.out.println(vehicle.toString());
        }
    }
}
