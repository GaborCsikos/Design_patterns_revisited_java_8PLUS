package week2.structural.facade;


public class PersonDetailsFacadeImpl implements PersonDetailsFacade {

    private PersonService personService; //Our system
    private AddressService addressService; // different system
    private TaxInformationService taxInformationService; // different system

    public PersonDetailsFacadeImpl(PersonService personService, AddressService addressService, TaxInformationService taxInformationService) {
        this.personService = personService;
        this.addressService = addressService;
        this.taxInformationService = taxInformationService;
    }

    @Override
    public PersonDetailsDTO loadPersonWithDetails(long personId) {
        PersonDetailsDTO dto = new PersonDetailsDTO();
        PersonEntity personEntity = personService.findById(personId);
        AddressDTO addressDTO = addressService.getAdressByIdentyNumber(personEntity.getIdentityNumber());
        TaxDTO taxDTO = taxInformationService.collectTaxInfo(personEntity.getIdentityNumber());
        dto.setAddressDTO(addressDTO);
        dto.setTaxInformation(taxDTO);
        return dto;
    }
}
