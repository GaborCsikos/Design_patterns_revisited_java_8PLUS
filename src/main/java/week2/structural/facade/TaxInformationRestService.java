package week2.structural.facade;

public class TaxInformationRestService implements TaxInformationService {
    @Override
    public TaxDTO collectTaxInfo(String taxCardNumber) {
        //Making expensive REST call to other service.
        return new TaxDTO();
    }
}
