package dto;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import week1.cretional.prototype.Address;
import week1.cretional.prototype.AddressWithClone;
import week1.cretional.prototype.Person;
import week1.cretional.prototype.PersonWithClone;

import static org.junit.Assert.assertEquals;

public class PrototypeTest {

    @Test
    public void badExample(){
        Address address = new Address("Budapest", "Vaci ut 11", "1138");
        Person person = new Person("Aizhan", address);
        Person personCopied = person;
        personCopied.setName("Szabina");
        assertEquals("Szabina", personCopied.getName());
        assertEquals("Aizhan", person.getName());
    }

    @Test
    public void copyWithClone(){
        AddressWithClone address = new AddressWithClone("Budapest", "Vaci ut 11", "1138");
        PersonWithClone person = new PersonWithClone("Aizhan", address);
        PersonWithClone personCopied = (PersonWithClone)person.clone();
        personCopied.setName("Szabina");
        assertEquals("Szabina", personCopied.getName());
        assertEquals("Aizhan", person.getName());
    }

    @Test
    public void copyWithSerialization(){
        Address address = new Address("Budapest", "Vaci ut 11", "1138");
        Person person = new Person("Aizhan", address);
        Person personCopied =  SerializationUtils.roundtrip(person);
        personCopied.setName("Szabina");
        assertEquals("Szabina", personCopied.getName());
        assertEquals("Aizhan", person.getName());
    }
}
