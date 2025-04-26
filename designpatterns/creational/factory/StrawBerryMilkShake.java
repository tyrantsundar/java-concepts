package designpatterns.creational.factory;

public class StrawBerryMilkShake implements MilkShake{
    @Override
    public void makeMilkShake() {
        System.out.println("Strawberry MilkShake Ready!!!");
    }
}
