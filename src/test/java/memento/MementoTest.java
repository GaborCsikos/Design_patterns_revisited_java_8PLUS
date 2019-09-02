package memento;

import org.junit.Test;
import week3.memento.CareTaker;
import week3.memento.Life;
import week3.memento.Memento;

import static org.junit.Assert.assertEquals;

public class MementoTest {

    @Test
    public void testMemento() {
        Life life = new Life("1980.03.16");


        CareTaker careTaker = new CareTaker();
        Memento toRollBack = careTaker.saveToMemento(life);

        life.set("BAD_ROLL_BACK");
        assertEquals("BAD_ROLL_BACK", life.getTime());

        life = careTaker.restoreFromMemento(toRollBack);

        assertEquals("1980.03.16", life.getTime());


    }
}
