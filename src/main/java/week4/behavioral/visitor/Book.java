package week4.behavioral.visitor;

public class Book implements Element {
    private int price;
    private String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    //accept the visitor
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}