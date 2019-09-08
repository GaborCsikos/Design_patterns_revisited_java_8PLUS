package bridge;

import org.junit.Test;
import week2.structural.bridge.*;

import static org.junit.Assert.assertEquals;

public class BridgeTest {

    @Test
    public void testBridge() {
        Shape redTriangle = new Triangle(new RedColor());
        assertEquals("Red Triangle", redTriangle.applyColor());

        Shape greenTriangle = new Triangle(new GreenColor());
        assertEquals("Green Triangle", greenTriangle.applyColor());


        Shape square = new Square(new GreenColor());
        assertEquals("Green Square", square.applyColor());
    }
}
