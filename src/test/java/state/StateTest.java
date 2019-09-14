package state;

import org.junit.Test;
import week4.behavioral.state.TicketState;
import week4.behavioral.state.TicketStateWithStateMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StateTest {

    @Test
    public void testState() {
        assertEquals("Red", TicketState.SUBMITTED.color());
        assertEquals("Blue", TicketState.INPROGRESS.color());
        assertEquals("Green", TicketState.RESOLVED.color());

    }

    //IMPORTANT each state change can be a separate test
    @Test
    public void testStateMachine() {
        assertEquals("Red", TicketStateWithStateMachine.SUBMITTED.color());
        assertEquals("Blue", TicketStateWithStateMachine.INPROGRESS.color());
        assertEquals("Green", TicketStateWithStateMachine.RESOLVED.color());


        //From Submit
        assertEquals(TicketStateWithStateMachine.INPROGRESS, TicketStateWithStateMachine.SUBMITTED.nextState());
        assertNull(TicketStateWithStateMachine.SUBMITTED.previousSate());

        //From In progress
        assertEquals(TicketStateWithStateMachine.RESOLVED, TicketStateWithStateMachine.INPROGRESS.nextState());
        assertEquals(TicketStateWithStateMachine.SUBMITTED, TicketStateWithStateMachine.INPROGRESS.previousSate());

        //From resolved
        assertNull(TicketStateWithStateMachine.RESOLVED.nextState());
        assertEquals(TicketStateWithStateMachine.INPROGRESS, TicketStateWithStateMachine.RESOLVED.previousSate());
    }
}
