package builder;

import org.junit.Test;
import week1.cretional.builder.GenericBuilder;
import week1.cretional.builder.Person;
import week1.cretional.builder.PersonBuilder;
import week1.cretional.builder.PersonWithLombok;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

    @Test
    public void testGenericBuilder() {
        Person person = GenericBuilder.of(Person::new)
                .with(Person::setFirstName, "Gabor")
                .with(Person::setLastName, "Csikos")
                .with(Person::setAge, 31).build();

        assertEquals("Gabor", person.getFirstName());
        assertEquals("Csikos", person.getLastName());
        assertEquals(31, person.getAge());
    }

    @Test
    public void lombokBuilder() {
        PersonWithLombok person = PersonWithLombok.builder().lastName("Csikos").build();
        assertEquals("Csikos", person.getLastName());

    }

    @Test
    public void builder() {
        Person person = new PersonBuilder()
                .with($ -> {
                    $.firstName = "Gabor";
                    $.lastName = "Csikos";
                })
                .with($ -> $.age = 31)
                .createPerson();
        assertEquals("Gabor", person.getFirstName());
        assertEquals("Csikos", person.getLastName());
        assertEquals(31, person.getAge());
    }
}
