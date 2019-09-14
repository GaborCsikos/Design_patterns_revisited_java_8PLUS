package week4.behavioral.visitor;

public interface Visitor {
    void visit(Book book);

    void visit(Dvd dvd);
}
