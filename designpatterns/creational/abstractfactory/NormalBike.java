package designpatterns.creational.abstractfactory;

public class NormalBike extends Bike{
    @Override
    public void bookVehicle() {
        System.out.println("NormalBike Booked!!!");
    }
}
