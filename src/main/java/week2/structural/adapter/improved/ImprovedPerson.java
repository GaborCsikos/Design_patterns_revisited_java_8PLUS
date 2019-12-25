package week2.structural.adapter.improved;


public interface ImprovedPerson {

    static ImprovedPerson adapt(StillALegacyPerson legacyPerson) {
        return () -> legacyPerson.getFirstName() + " " + legacyPerson.getLastName();
    }

    String getName();

}
