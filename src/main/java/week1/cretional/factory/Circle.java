package week1.cretional.factory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    @Override
    public String getType() {
        return ShapeType.CIRCLE.name();
    }
}