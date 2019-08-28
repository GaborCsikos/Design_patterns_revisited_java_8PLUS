package week2.structural.bridge;

public class Triangle extends Shape {

    public Triangle(Color c) {
        super(c);
    }

    @Override
    public String applyColor() {
        return color.applyColor() + " Triangle";
    }

}