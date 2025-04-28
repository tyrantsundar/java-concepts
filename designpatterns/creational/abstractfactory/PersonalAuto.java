package designpatterns.creational.abstractfactory;

public class PersonalAuto extends Auto{
    @Override
    public void bookVehicle() {
        System.out.println("Personal Auto Booked!!!");
    }
}
