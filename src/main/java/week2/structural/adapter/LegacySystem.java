package week2.structural.adapter;

public class LegacySystem {

    public LegacyPerson getPerson() {
        return new LegacyPerson("Szabina", "Csikos");
    }

}
