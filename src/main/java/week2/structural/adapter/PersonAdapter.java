package week2.structural.adapter;

import org.apache.commons.lang3.StringUtils;

public class PersonAdapter extends NewPersonService {

    private LegacySystem legacySystem;

    public PersonAdapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public Person getPerson() {
        //TODO explain why this is not the best approach and do a refactor, 1 call is enought
        //TODO StringUtils.SPACE
        String name = legacySystem.getPerson().getFirstName() + StringUtils.SPACE + legacySystem.getPerson().getLastName();
        return new Person(name);
    }
}
