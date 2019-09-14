package week4.behavioral.state;

public enum TicketStateWithStateMachine {
    SUBMITTED {
        @Override
        public String color() {
            return "Red";
        }

        @Override
        public TicketStateWithStateMachine nextState() {
            return TicketStateWithStateMachine.INPROGRESS;

        }

        @Override
        public TicketStateWithStateMachine previousSate() {
            return null;  //or NotAllowed
        }
    },

    INPROGRESS {
        @Override
        public String color() {
            return "Blue";
        }

        @Override
        public TicketStateWithStateMachine nextState() {
            return TicketStateWithStateMachine.RESOLVED;
        }

        @Override
        public TicketStateWithStateMachine previousSate() {
            return TicketStateWithStateMachine.SUBMITTED;
        }
    }, RESOLVED {
        @Override
        public String color() {
            return "Green";
        }

        @Override
        public TicketStateWithStateMachine nextState() {
            return null;
        }

        @Override
        public TicketStateWithStateMachine previousSate() {
            return TicketStateWithStateMachine.INPROGRESS;
        }
    };

    public abstract String color();

    public abstract TicketStateWithStateMachine nextState();

    public abstract TicketStateWithStateMachine previousSate();
}
