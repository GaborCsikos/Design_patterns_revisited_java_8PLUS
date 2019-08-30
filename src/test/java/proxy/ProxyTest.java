package proxy;

import org.junit.Test;
import week2.structural.proxy.dynamic.HealthCheckHandler;
import week2.structural.proxy.dynamic.Human;
import week2.structural.proxy.dynamic.Person;
import week2.structural.proxy.protection.Image;
import week2.structural.proxy.protection.ProxyImage;
import week2.structural.proxy.simple.CarProxy;
import week2.structural.proxy.simple.Drivable;
import week2.structural.proxy.simple.Driver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static week2.structural.proxy.dynamic.DynamicProxy.addHandler;

public class ProxyTest {

    @Test
    public void testClassicProxy() {
        Image image = new ProxyImage();
        assertFalse(image.isLoaded());
        image.loadImage();
        assertTrue(image.isLoaded());
    }

    @Test
    public void testProtectionProxy() {
        Drivable myDaughterDrives = new CarProxy(new Driver(5));
        Drivable wifeDrives = new CarProxy(new Driver(39));
        assertFalse(myDaughterDrives.canDrive());
        assertTrue(wifeDrives.canDrive());

    }

    @Test
    public void testDynamicProxy() {
        Human person = new Person();
        assertFalse(HealthCheckHandler.isHealthy());

        Human withProxy = addHandler(person, Human.class);
        assertFalse(HealthCheckHandler.isHealthy());
        withProxy.doHealthCheck();
        assertTrue(HealthCheckHandler.isHealthy());
    }
}
