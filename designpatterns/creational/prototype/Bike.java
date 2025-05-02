package designpatterns.creational.prototype;

public class Bike extends Vehicle{
    public Bike(Bike bike){
        super(bike);
    }
    public Bike(){}
    @Override
    public Vehicle clone() {
        return new Bike(this);
    }
}
