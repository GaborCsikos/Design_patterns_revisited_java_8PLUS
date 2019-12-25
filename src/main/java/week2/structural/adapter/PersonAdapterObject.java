package week2.structural.adapter;

public class PersonAdapterObject implements Person {

    private LegacyPerson legacy;

    public PersonAdapterObject(LegacyPerson legacyPerson) {
        this.legacy = legacyPerson;
    }

    @Override
    public String getName() {
        return legacy.getFirstName() + " " + legacy.getLastName();
    }
}
