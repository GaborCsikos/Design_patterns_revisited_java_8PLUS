package adapter;

import org.junit.Test;
import week2.structural.adapter.LegacySystem;
import week2.structural.adapter.PersonAdapter;

import static org.junit.Assert.assertEquals;

public class AdapterTest {

    @Test
    public void testAdapter() {
        //given
        LegacySystem legacySystem = new LegacySystem();

        PersonAdapter personAdapter = new PersonAdapter(legacySystem);

        //when
        String name = personAdapter.getPerson().getFullName();

        //then
        assertEquals("Szabina Csikos", name);
    }
}
