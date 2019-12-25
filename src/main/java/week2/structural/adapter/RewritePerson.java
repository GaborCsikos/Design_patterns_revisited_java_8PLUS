package week2.structural.adapter;

public class RewritePerson implements Person {

    private String name;

    public RewritePerson() {

    }

    @Override
    public String getName() {
        return name;
    }
}
