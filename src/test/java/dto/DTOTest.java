package dto;


import org.junit.Test;
import week1.dto.FlightSystem;
import week1.dto.FlightTicketDTO;

import static org.junit.Assert.assertEquals;


public class DTOTest {

    private FlightSystem flightSystem = new FlightSystem();

    @Test
    public void gatherAllInformationOnce(){
        FlightTicketDTO dto = flightSystem.getInformation();
        assertEquals("A123", dto.getFlightNumber());


    }
}
