package designpatterns.creational.factory;

public class MilkShakeFactory {
    public MilkShake prepareMilkShake(MilkShakeName name){
        switch (name){
            case ORIO:
                return new OrioMilkShake();
            case VENNILA:
                return new VennilaMilkShake();
            case STRAWBERRY:
                return new StrawBerryMilkShake();
        }
        return null;
    }
}
