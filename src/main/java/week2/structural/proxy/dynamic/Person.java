package week2.structural.proxy.dynamic;

public class Person implements Human {

    @Override
    public void doHealthCheck() {
        System.out.println("doing HC");
    }
}
