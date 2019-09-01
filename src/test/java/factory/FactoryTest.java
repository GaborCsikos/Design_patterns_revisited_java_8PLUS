package factory;

import org.junit.Test;
import week1.cretional.builder.Person;
import week1.cretional.factory.*;

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
        assertEquals(ShapeType.CIRCLE.name(), shape.getType());


        //Test the name the persons with bank account

        Person person = PersonFactory.getPerson(PersonType.PERSON_WITH_BACK_ACCOUNT);
    }
}
