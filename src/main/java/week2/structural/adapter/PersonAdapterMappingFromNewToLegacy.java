package week2.structural.adapter;

import org.apache.commons.lang3.StringUtils;

public class PersonAdapterMappingFromNewToLegacy extends LegacySystem {

    private NewPersonService newPersonService;

    public PersonAdapterMappingFromNewToLegacy(NewPersonService newPersonService) {
        this.newPersonService = newPersonService;
    }

    @Override
    public LegacyPerson getPerson() {
        String name = "";
        return new LegacyPerson("", "");
    }
}
