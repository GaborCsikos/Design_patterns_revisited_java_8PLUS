package week2.structural.facade;

public class PersonDetailsDTO {

    private TaxDTO taxInformation;
    private AddressDTO addressDTO;

    public TaxDTO getTaxInformation() {
        return taxInformation;
    }

    public void setTaxInformation(TaxDTO taxInformation) {
        this.taxInformation = taxInformation;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
