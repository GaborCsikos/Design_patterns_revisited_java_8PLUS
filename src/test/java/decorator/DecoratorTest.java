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
}
