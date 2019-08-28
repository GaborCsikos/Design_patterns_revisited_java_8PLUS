package week2.structural.bridge;

public class Square extends Shape {

    public Square(Color c) {
        super(c);
    }

    @Override
    public String applyColor() {
        return color.applyColor() + " Square";
    }

}