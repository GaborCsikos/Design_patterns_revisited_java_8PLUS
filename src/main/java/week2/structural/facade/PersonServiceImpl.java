package week2.structural.facade;

public class PersonServiceImpl implements PersonService {
    @Override
    public PersonEntity findById(long id) {
        return new PersonEntity("");
    }
}
