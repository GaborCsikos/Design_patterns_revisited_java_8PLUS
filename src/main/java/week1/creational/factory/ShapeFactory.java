package week1.creational.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory {

    final static Map<ShapeType, Supplier<Shape>> map = new HashMap<>();

    static {
        map.put(ShapeType.CIRCLE, Circle::new);
        map.put(ShapeType.SQUARE, Square::new);
    }

    public Shape getShape(ShapeType shapeType) {
        Supplier<Shape> shape = map.get(shapeType);
        if (shape != null) {
            Shape shapeAsObject = shape.get();
            shapeAsObject.setValueForTest(10);
            return shapeAsObject;
        }

        throw new IllegalArgumentException("No such shape " + shapeType.name());
    }
}