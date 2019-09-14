package week4.behavioral.visitor;


public class NameVisitor implements Visitor {
    private String names;


    @Override
    public void visit(Book book) {
        if (names != null) {
            names = names + ", " + book.getName();
        } else {
            names = book.getName();
        }
    }

    @Override
    public void visit(Dvd dvd) {
        if (names != null) {
            names = names + ", " + dvd.getName();
        } else {
            names = dvd.getName();
        }
    }

    public String getNames() {
        return names;
    }
}