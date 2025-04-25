package designpatterns.creational.singleton;

public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }
}

/**
 *
 * Enum-based Singleton (Best Practice)
 *
 * Handles Serialization & Reflection issues
 * Recommended by Effective Java (Joshua Bloch)
 * */