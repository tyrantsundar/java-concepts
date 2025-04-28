package designpatterns.creational.abstractfactory;

public class AutoFactory extends AbstractVehicleFactory{
    @Override
    public Vehicle getVehicle(String type) {
        switch (type){
            case "share":
                return new ShareAuto();
            case "personal":
                return new PersonalAuto();
        }
        return null;
    }
}
