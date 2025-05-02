package designpatterns.creational.prototype;

public class Car extends Vehicle{

    public Car(){}
    public Car(Car car){
        super(car);
    }
    @Override
    public Vehicle clone() {
        return new Car(this);
    }
}
