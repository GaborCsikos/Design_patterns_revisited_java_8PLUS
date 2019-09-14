package week1.creational.factory;

import week1.creational.builder.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PersonFactory {

    final static Map<PersonType, Supplier<Person>> map = new HashMap<>();

    static {
        map.put(PersonType.PERSON_WITH_BACK_ACCOUNT, Person::new);
        map.put(PersonType.PERSON_WITH_FULL_ADDRESS, Person::new);
    }

    static public Person getPerson(PersonType personType) {
        Supplier<Person> person = map.get(personType);
        if (person != null) {
            Person personToReturn = person.get();
            switch (personType) {
                case PERSON_WITH_BACK_ACCOUNT:
                    personToReturn.setAge(18);
                    personToReturn.setLastName("Example");
                    break;
                case PERSON_WITH_FULL_ADDRESS:
                    personToReturn.setLastName("Test");
                    break;

            }
            return personToReturn;
        }

        throw new IllegalArgumentException("No such shape " + personType.name());
    }
}