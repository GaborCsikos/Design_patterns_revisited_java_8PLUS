package flyweight;

import org.junit.Test;
import week2.structural.flyweight.BetterFormattedText;
import week2.structural.flyweight.FormattedText;

import static org.junit.Assert.assertTrue;

public class FlyWeightTest {


    @Test
    public void testFormat() {
        FormattedText ft = new FormattedText("Hello from Hungary");
        ft.capitalize(11, 17);
        System.out.println(ft);
        System.out.println("without flyweight memory used:" + ft.getMemoryUsed());

        BetterFormattedText bft = new BetterFormattedText("Hello from Hungary");
        bft.getRange(11, 17).capitalize = true;
        System.out.println(bft);
        System.out.println("with flyweight memory used:" + bft.getMemoryUsed());
        assertTrue(bft.getMemoryUsed() < ft.getMemoryUsed());
    }
}
