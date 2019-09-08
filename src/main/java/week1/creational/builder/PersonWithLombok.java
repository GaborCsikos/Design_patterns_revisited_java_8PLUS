package week1.creational.builder;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonWithLombok {
    private String firstName;
    private String lastName;
    private int age;

}
