package week4.behavioral.template;

public abstract class ColoredShape {
    private String color;

    public ColoredShape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}