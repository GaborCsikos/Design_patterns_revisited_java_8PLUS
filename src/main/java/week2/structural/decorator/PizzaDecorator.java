package week2.structural.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class PizzaDecorator {
    private final Function<Pizza, Pizza> toppings;

    private PizzaDecorator(Function<Pizza, Pizza>... desiredToppings) {
        this.toppings = Stream.of(desiredToppings)
                .reduce(Function.identity(), Function::andThen);

    }

    public static int getPrice(Pizza pizza, Function<Pizza, Pizza>... desiredToppings) {
        return new PizzaDecorator(desiredToppings).getPrice(pizza);
    }

    private int getPrice(Pizza pizza) {
        return this.toppings.apply(pizza).getPriceOfPizza();
    }

}