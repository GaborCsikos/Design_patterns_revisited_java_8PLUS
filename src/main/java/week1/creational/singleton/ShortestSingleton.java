package week1.creational.singleton;

public enum ShortestSingleton {
    INSTANCE(0);

    private int counter;

    ShortestSingleton(int counter) {
        this.counter++;
        System.out.println("Contructor called");
    }

    public int getCounter() {
        return counter;
    }

}
