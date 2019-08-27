package week1.cretional.builder;

import java.util.function.Consumer;

public class PersonBuilder {
    public String firstName;
    public String lastName;
    public int age;

    public PersonBuilder with(Consumer<PersonBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }


    public Person createPerson() {
        return new Person(firstName,lastName,age);
    }
}
