package designpatterns.creational.abstractfactory;

public class Main {


//    Abstract Factory Design Pattern, as the name suggests is an abstraction over Factory design pattern.
//    It is one of the creational design patterns. As a factory pattern allows us to create a generic factory
//    of one or more than one type of object, extending the same behavior abstract factory design pattern
//    allows us to create a factory of factories, one level above the abstraction in the factory design pattern

    /// FAQS
//    1. Can Abstract Factory Design Pattern be implemented as Singleton Design Pattern?
//    Yes

//    2. What are the consequences of using the Abstract Factory Design Pattern?
//    i)   It isolates concrete classes by helping you to control the classes of objects which
//         are created by the application because in an abstract factory pattern a factory encapsulates
//         the responsibility and the process of creating product objects, it isolates clients from implementation classes details.
//    ii)  It makes exchanging product families easy.
//    iii) It promotes consistency among products
    public static void main(String[] args) {
        AbstractVehicleFactory abstractVehicleFactory;
        Vehicle vehicle;

        //ShareAuto and PersonalAuto
        abstractVehicleFactory = FactoryProvider.getVehicleFactory("auto");
        vehicle = abstractVehicleFactory.getVehicle("share");
        vehicle.bookVehicle();

        vehicle = abstractVehicleFactory.getVehicle("personal");
        vehicle.bookVehicle();

        //Super and Normal Bike
        abstractVehicleFactory = FactoryProvider.getVehicleFactory("bike");
        vehicle = abstractVehicleFactory.getVehicle("super");
        vehicle.bookVehicle();

        vehicle = abstractVehicleFactory.getVehicle("normal");
        vehicle.bookVehicle();

        //Mini , Mega and Super Car
        abstractVehicleFactory = FactoryProvider.getVehicleFactory("car");
        vehicle = abstractVehicleFactory.getVehicle("mini");
        vehicle.bookVehicle();

        vehicle = abstractVehicleFactory.getVehicle("mega");
        vehicle.bookVehicle();

        vehicle = abstractVehicleFactory.getVehicle("super");
        vehicle.bookVehicle();
    }
}
