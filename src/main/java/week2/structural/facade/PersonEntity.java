package week2.structural.facade;

public class PersonEntity {
    private String identityNumber;

    public PersonEntity(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
}
