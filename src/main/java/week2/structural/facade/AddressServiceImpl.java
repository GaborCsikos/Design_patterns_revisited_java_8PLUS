package week2.structural.facade;

public class AddressServiceImpl implements AddressService {
    @Override
    public AddressDTO getAdressByIdentyNumber(String identityNumber) {
        return new AddressDTO();
    }
}
