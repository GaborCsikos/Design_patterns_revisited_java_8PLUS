package week1.cretional.prototype;

public class PersonWithClone implements Cloneable{
    private String name;
    private AddressWithClone address;

    public PersonWithClone(String name, AddressWithClone address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressWithClone getAddress() {
        return address;
    }

    public void setAddress(AddressWithClone address) {
        this.address = address;
    }

    //WARNING by default shallow copy is made
    @Override
    public Object clone(){
        return new PersonWithClone(name,
                address instanceof Cloneable ? (AddressWithClone) address.clone() : address
        );
    }
}
