package designpatterns.creational.abstractfactory;

public class SuperBike extends Bike{
    @Override
    public void bookVehicle() {
        System.out.println("SuperBike Booked!!!");
    }
}
