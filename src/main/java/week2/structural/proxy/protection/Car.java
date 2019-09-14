package week2.structural.proxy.protection;

public class Car {

    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    public String drive() {
        return "driving:" + driver.getName();
    }
}
