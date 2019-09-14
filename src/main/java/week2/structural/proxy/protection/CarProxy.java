package week2.structural.proxy.protection;


public class CarProxy extends Car {
    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public String drive() {
        if (driver.getAge() >= 17)
            return driver.getName() + " is driving";
        else
            return "Too young to drive";
    }
}