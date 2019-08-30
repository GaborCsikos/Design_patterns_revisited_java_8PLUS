package specification;

import org.junit.Test;
import week3.specification.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SpecificationTest {

    @Test
    public void testSpecification() {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);
        List<Product> products = List.of(apple, tree, house);
        BetterFilter bf = new BetterFilter();

        List<Product> onlyBlue = bf.filter(products, new ColorSpecification(Color.BLUE)).collect(Collectors.toList());
        assertEquals(1, onlyBlue.size());
        assertEquals(Color.BLUE, onlyBlue.get(0).getColor());
        assertEquals("House", onlyBlue.get(0).getName());


        List<Product> onlySmall = bf.filter(products, new SizeSpecification(Size.SMALL)).collect(Collectors.toList());
        assertEquals(1, onlySmall.size());
        assertEquals(Size.SMALL, onlySmall.get(0).getSize());
        assertEquals("Apple", onlySmall.get(0).getName());


        List<Product> greenAndLarge = bf.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(Color.GREEN),
                        new SizeSpecification(Size.LARGE)
                )).collect(Collectors.toList());
        assertEquals(1, greenAndLarge.size());
        assertEquals(Size.LARGE, greenAndLarge.get(0).getSize());
        assertEquals(Color.GREEN, greenAndLarge.get(0).getColor());
        assertEquals("Tree", greenAndLarge.get(0).getName());

    }
}
