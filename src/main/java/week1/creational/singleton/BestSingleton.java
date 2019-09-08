package week1.creational.singleton;

public class BestSingleton {

    private int counter = 0;

    private BestSingleton() {
        System.out.println("Running contructor");
        counter++;
    }

    public static BestSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private static class SingletonHelper {
        private static final BestSingleton INSTANCE = new BestSingleton();
    }
}