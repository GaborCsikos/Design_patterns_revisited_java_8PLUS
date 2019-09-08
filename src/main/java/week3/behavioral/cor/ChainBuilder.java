package week3.behavioral.cor;

public class ChainBuilder<T> {
    private HandlerImpl<T> first;

    private ChainBuilder() {
    }

    public static <T> ChainBuilder<T> chainBuilder() {
        return new ChainBuilder<>();
    }

    public SuccessorBuilder first(Handler<T> handler) {
        first = new HandlerImpl<>(handler);
        return new SuccessorBuilder(first);
    }

    private static class ChainImpl<T> implements Chain<T> {
        private final Handler<T> first;

        public ChainImpl(Handler<T> first) {
            this.first = first;
        }

        @Override
        public void handle(T t) {
            first.handle(t);
        }
    }

    private static class HandlerImpl<T> implements Handler<T> {
        private final Handler<T> currentOrDelagete;
        private Handler<T> successor;

        public HandlerImpl(Handler<T> delegate) {
            this.currentOrDelagete = delegate;
        }

        private void setSuccessor(HandlerImpl<T> successor) {
            this.successor = successor;
        }

        @Override
        public boolean handle(T t) {
            if (currentOrDelagete.handle(t)) {
                return true;
            } else if (successor != null) {
                return successor.handle(t);
            }
            //If nobody can handle
            return false;
        }
    }

    public class SuccessorBuilder {
        private HandlerImpl<T> current;

        private SuccessorBuilder(HandlerImpl<T> current) {
            this.current = current;
        }

        public SuccessorBuilder successor(Handler<T> successor) {
            HandlerImpl<T> successorWrapper = new HandlerImpl<>(successor);
            current.setSuccessor(successorWrapper);
            current = successorWrapper;
            return this;
        }

        public Chain<T> build() {
            return new ChainImpl<T>(first);
        }
    }
}