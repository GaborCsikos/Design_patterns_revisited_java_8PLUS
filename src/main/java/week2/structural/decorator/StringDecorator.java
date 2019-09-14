package week2.structural.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class StringDecorator {
    private final Function<String, String> strings;

    private StringDecorator(Function<String, String>... incoming) {
        this.strings = Stream.of(incoming)
                .reduce(Function.identity(), Function::andThen);

    }

    public static String getResultString(String first, Function<String, String>... desiredToppings) {
        return new StringDecorator(desiredToppings).getResultString(first);
    }


    public static String getResultString2(String first, Function<String, String>... desiredToppings) {
        return new StringDecorator(desiredToppings).strings.apply(first);
    }

    private String getResultString(String getResultString) {
        return this.strings.apply(getResultString);
    }

}