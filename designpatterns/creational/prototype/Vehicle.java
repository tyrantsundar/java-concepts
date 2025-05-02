package designpatterns.creational.prototype;

public abstract class Vehicle {
    int noOfSeat;
    int noOfTyre;
    String colour;

    public Vehicle(){}
    public Vehicle(Vehicle vehicle) {
        this.noOfSeat = vehicle.noOfSeat;
        this.noOfTyre = vehicle.noOfTyre;
        this.colour = vehicle.colour;
    }

    public abstract Vehicle clone();
    @Override
    public String toString(){
        return "\nSeat:"+noOfSeat+"\nType:"+noOfTyre+"\nColour:"+colour;
    }
}
