package week1.creational.factory;

public class Square implements Shape {
    private int value;

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    @Override
    public String getType() {
        return ShapeType.SQUARE.name();
    }

    @Override
    public void setValueForTest(int value) {
        this.value = value;
    }

    @Override
    public int getValueForShope() {
        return value;
    }
}