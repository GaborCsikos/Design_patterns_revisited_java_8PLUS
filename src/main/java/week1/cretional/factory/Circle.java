package week1.cretional.factory;

public class Circle implements Shape {


    private int value;

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    @Override
    public String getType() {
        return ShapeType.CIRCLE.name();
    }

    @Override
    public void setValueForTest(int value) {
        this.value= value;
    }

    @Override
    public int getValueForShope() {
        return value;
    }
}