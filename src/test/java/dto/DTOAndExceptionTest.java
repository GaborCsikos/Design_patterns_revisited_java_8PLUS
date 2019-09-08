package dto;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import week1.creational.dto.FlightSystem;
import week1.creational.dto.FlightTicketDTO;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class DTOAndExceptionTest {

    private FlightSystem flightSystem = new FlightSystem();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void gatherAllInformationOnce() {
        FlightTicketDTO dto = flightSystem.getInformation();
        assertEquals("A123", dto.getFlightNumber());

        List<String> example = new LinkedList<String>();
        doSomething(example);
    }

    private void doSomething(List<String> somegting){
        ///
    }

    @Test(expected =  NullPointerException.class)
    public void testNPE(){
        flightSystem.testNPE(null);
    }

    @Test
    public void testNPEExample(){
        try {
            flightSystem.testNPE("CAT");
            fail();
        }catch (NullPointerException e){
            assertEquals(e.getMessage(), "ABC");
        }
    }




    @Test
    public void whenExceptionThrown_thenRuleIsApplied() {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("NPE");
        flightSystem.testNPE(null);
    }
}
