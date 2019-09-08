package template;

import org.junit.Test;
import week4.behavioral.template.ColoredShape;
import week4.behavioral.template.RedRectangel;

import static org.junit.Assert.assertEquals;


public class TemplateTest {

    @Test
    public void testTeamplete() {
        ColoredShape redRectangle = new RedRectangel("red");
        assertEquals("red", redRectangle.getColor());
    }
}
