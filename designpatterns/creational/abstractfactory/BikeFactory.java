package designpatterns.creational.abstractfactory;

public class BikeFactory extends AbstractVehicleFactory{
    @Override
    public Vehicle getVehicle(String type) {
        switch (type){
            case "normal":
                return new NormalBike();
            case "super":
                return new SuperBike();
        }
        return null;
    }
}
