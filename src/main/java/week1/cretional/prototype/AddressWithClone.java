package week1.cretional.prototype;

public class AddressWithClone implements Cloneable{
    private String city;
    private String street;
    private String postalCode;

    public AddressWithClone(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public Object clone(){
        return new AddressWithClone(city,street, postalCode);
    }
}
