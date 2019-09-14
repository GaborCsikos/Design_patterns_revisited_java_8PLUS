package visitor;

import org.junit.Test;
import week4.behavioral.visitor.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    @Test
    public void visitorTest() {
        Book book1 = new Book(100, "Book1");
        Book book2 = new Book(200, "Book2");
        Book book3 = new Book(300, "Book3");

        Dvd dvd1 = new Dvd(500, "Dvd1");
        Dvd dvd2 = new Dvd(1000, "Dvd2");
        Dvd dvd3 = new Dvd(1500, "Dvd3");
        List<Element> elements = new ArrayList<>();
        elements.add(book1);
        elements.add(book2);
        elements.add(book3);
        elements.add(dvd1);
        elements.add(dvd2);
        elements.add(dvd3);

        PriceVisitor priceVisitor = new PriceVisitor();
        NameVisitor nameVisitor = new NameVisitor();

        for (Element item : elements) {
            item.accept(priceVisitor);
            item.accept(nameVisitor);
        }

        assertEquals(3600, priceVisitor.getTotal());
        assertEquals("Book1, Book2, Book3, Dvd1, Dvd2, Dvd3", nameVisitor.getNames());

    }
}
