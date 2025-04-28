package designpatterns.creational.abstractfactory;

public class CarFactory extends AbstractVehicleFactory{

    @Override
    public Vehicle getVehicle(String type) {
        switch (type){
            case "mini":
                return new MiniCar();
            case "mega":
                return new MegaCar();
            case "super":
                return new SuperCar();
        }
        return null;
    }
}
