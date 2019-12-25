package week2.structural.adapter;

public class PersonAdapterClass extends RewritePerson {

    private LegacyPerson legacy;

    public PersonAdapterClass(LegacyPerson legacyPerson) {
        this.legacy = legacyPerson;
    }

    @Override
    public String getName() {
        return legacy.getFirstName() + " " + legacy.getLastName();
    }
}
