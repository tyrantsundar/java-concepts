package designpatterns.creational.singleton;

public class BillPughSingleton {

    // Private constructor to prevent instantiation
    private BillPughSingleton() {
        System.out.println("Singleton instance created");
    }

    // Static inner class - loaded only when getInstance() is called
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Global access point
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}


/**
 *
 * Why it works?
 *  i)  The inner static class SingletonHelper is not loaded into memory
 *      until the getInstance() method is called.
 *  ii) JVM ensures that the static inner class is loaded only once and in a
 *      thread-safe way — no need for synchronized.
 *
 *
 *
 * ⚡ Advantages:
 *      i)   Thread-safe
 *      ii)  Lazy-loaded
 *      iii) No synchronization overhead
 *       iv) Simple and readable
 * */

