package week1.cretional.factory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    @Override
    public String getType() {
        return ShapeType.SQUARE.name();
    }
}