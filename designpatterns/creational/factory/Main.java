package designpatterns.creational.factory;

public class Main {

//    1. What is Factory Design Pattern
//    Factory design pattern is a creational design pattern that separates the logic of creating
//    objects from the client code. The factory class in the factory design pattern is responsible
//    for creating objects based on the request from the client.

//    2. Pros and Cons of Factory Design Pattern

    //Pros
    //i)   Factory design pattern provides great extensibility that lets us add new classes without
    //     changing the application.
    //ii)  Factory design pattern leverages loose coupling and eliminates hard binding the
    //     application-specific login in the code.
    //iii) The factory method returns the Product interface. So, it can work for any concrete
    //     product implementation.
    //Cons
    //i)   Creation of all the concrete product instances are tightly coupled with the factory class that involves code modification when a new concrete product is introduced.

    //    FAQs
    //    1. What is a Factory in Factory design pattern?
    //    The factory is a terminology that denotes a class or method responsible
    //    for creating/producing an object. E.g.: PhoneFactory is responsible for producing phones.
    //
    //     2. What is a Factory method in Factory design pattern?
    //     The factory method is responsible for creating and returning the objects to the client.
    //     A factory method may accept an input that denotes the type of object that needs to be created.
    public static void main(String[] args) {
        MilkShakeFactory milkShakeFactory = new MilkShakeFactory();
        MilkShake milkShake;
        //Vennila MilkShake
        milkShake = milkShakeFactory.prepareMilkShake(MilkShakeName.VENNILA);
        milkShake.makeMilkShake();

        //Strawberry MilkShake
        milkShake = milkShakeFactory.prepareMilkShake(MilkShakeName.STRAWBERRY);
        milkShake.makeMilkShake();

        //Orio MilkShake
        milkShake = milkShakeFactory.prepareMilkShake(MilkShakeName.ORIO);
        milkShake.makeMilkShake();
    }
}
