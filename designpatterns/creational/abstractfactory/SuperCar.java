package designpatterns.creational.abstractfactory;

public class SuperCar extends Car{
    @Override
    public void bookVehicle() {
        System.out.println("Super Car Booked!!!");
    }
}
