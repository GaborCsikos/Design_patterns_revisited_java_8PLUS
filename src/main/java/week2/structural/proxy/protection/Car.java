package week2.structural.proxy.protection;

public class Car implements Drivable
{
    protected Driver driver;

    public Car(Driver driver)
    {
        this.driver = driver;
    }

    @Override
    public boolean canDrive()
    {
       return canDrive();
    }
}