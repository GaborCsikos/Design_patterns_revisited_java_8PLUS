package week4.behavioral.visitor;


public class PriceVisitor implements Visitor {
    private int total;


    @Override
    public void visit(Book book) {
        total += book.getPrice();
    }

    @Override
    public void visit(Dvd dvd) {
        total += dvd.getPrice();
    }

    public int getTotal() {
        return total;
    }
}