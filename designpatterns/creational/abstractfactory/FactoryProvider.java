package designpatterns.creational.abstractfactory;

public class FactoryProvider {
    public static AbstractVehicleFactory getVehicleFactory(String factory){
        if(factory.equals("car")){
            return new CarFactory();
        }else if(factory.equals("auto")){
            return new AutoFactory();
        }else{
            return new BikeFactory();
        }
    }
}
