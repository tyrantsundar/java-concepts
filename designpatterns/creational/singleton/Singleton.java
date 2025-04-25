package designpatterns.creational.singleton;

public class Singleton {
    // Volatile keyword ensures visibility across threads
    private static volatile Singleton instance;

    // Private constructor
    private Singleton() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    // Thread-safe with double-checked locking
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // To protect from serialization
    protected Object readResolve() {
        return getInstance();
    }

}
