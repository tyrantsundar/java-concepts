package designpatterns.creational.abstractfactory;

public class ShareAuto extends Auto{
    @Override
    public void bookVehicle() {
        System.out.println("Share Auto Booked!!!");
    }
}
