package factory;

import org.junit.Test;
import week1.cretional.factory.Car;
import week1.cretional.factory.Shape;
import week1.cretional.factory.ShapeFactory;
import week1.cretional.factory.ShapeType;

import static org.junit.Assert.assertEquals;

public class FactoryTest {

    @Test
    public void factoryMethod() {
        Car car = Car.newAmbulance("AAA-123");
        assertEquals("White", car.getColor());
    }

    @Test
    public void testFactory() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape(ShapeType.CIRCLE);
        shape.draw();
    }
}
