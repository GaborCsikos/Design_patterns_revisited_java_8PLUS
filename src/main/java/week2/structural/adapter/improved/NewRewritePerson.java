package week2.structural.adapter.improved;

import week2.structural.adapter.Person;

public class NewRewritePerson implements Person {

    private String name;

    public NewRewritePerson() {

    }

    public NewRewritePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
