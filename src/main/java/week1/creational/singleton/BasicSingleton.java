package week1.creational.singleton;

import java.io.Serializable;

public class BasicSingleton implements Serializable {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private int counter = 0;

    private BasicSingleton() {
        System.out.println("Singleton is initializing");
        counter++;
    }

    // generated getter
    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getCounter() {
        return counter;
    }

    // required for correct serialization
    protected Object readResolve() {
        return INSTANCE;
    }


}
