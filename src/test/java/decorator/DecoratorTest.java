package decorator;

import org.junit.Test;
import week2.structural.decorator.BasicPizza;
import week2.structural.decorator.Pizza;
import week2.structural.decorator.PizzaDecorator;

import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void testDecorator() {
        int price = PizzaDecorator.getPrice(new BasicPizza(), Pizza::withExtraCheese, Pizza::withPepperoni);
        assertEquals(1500, price);
    }

    @Test
    public void testDecoratorSimple() {

        //Add cheese
        Pizza pizzaWithCheese = () -> new BasicPizza().getPriceOfPizza() + 200;

        //Add pepperoni
        Pizza pizzaWithCheeseAndPepperoni = () -> pizzaWithCheese.getPriceOfPizza() + 300;

        assertEquals(1500, pizzaWithCheeseAndPepperoni.getPriceOfPizza());
    }
}
