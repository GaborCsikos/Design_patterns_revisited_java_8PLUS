package week4.behavioral.state;

public enum TicketState {
    SUBMITTED {
        @Override
        public String color() {
            return "Red";
        }
    },

    INPROGRESS {
        @Override
        public String color() {
            return "Blue";
        }
    }, RESOLVED {
        @Override
        public String color() {
            return "Green";
        }
    };

    public abstract String color();
}
