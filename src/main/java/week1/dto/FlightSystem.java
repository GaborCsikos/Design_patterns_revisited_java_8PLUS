package week1.dto;

public class FlightSystem {
    public FlightTicketDTO getInformation() {
        FlightTicketDTO dto = new FlightTicketDTO();

        //comes from a different service containing airplane information
        dto.setSeatCode("A12");

        //comes from our service
        dto.setFlightNumber("A123");
        dto.setPassangerName("John Smith");
        dto.setTerminalNumber("2B");

        return dto;

    }


}
