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


    public void testNPE(String input) {
        String expected = "CAT";
       if(expected.equals(input)){
            throw  new NullPointerException("ABC");

        }
        throw  new NullPointerException("NPE");
        /*if(input.equals(expected)){
            System.out.println("ABC");
        }

        //better implementation
        if( "CAT".equals(input)){
            System.out.println("ABC");
        }*/
    }
}
