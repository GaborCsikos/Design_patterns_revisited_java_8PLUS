package week2.structural.proxy.protection;

public class CarProxy extends Car
{

    public CarProxy(Driver driver)
    {
        super(driver);
    }

    @Override
    public boolean canDrive()
    {
       return driver.getAge() >= 18;
    }
}