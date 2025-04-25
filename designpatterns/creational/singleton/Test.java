package designpatterns.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    }

    private void byPassSingleTonByReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        /**
         * Note :
         *      ➡️ Breaks Singleton because it bypasses the private constructor.
         *
         * Prevention : ✅ For Reflection, throw exception in constructor:
         * */
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s2 = constructor.newInstance();

    }

    private void byPassSingleTonBySerialization() throws IOException, ClassNotFoundException {
        /**
         * Note :
         *      If Singleton implements Serializable, deserializing it creates a new instance.
         *
         * Prevention : ✅ For Serialization, add readResolve() method:
         * */
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("file location"));
        outputStream.writeObject(Singleton.getInstance());

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file location"));
        Singleton singleton = (Singleton) inputStream.readObject();
    }


}
