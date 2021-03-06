package cor;

import org.junit.Test;
import week3.behavioral.cor.Chain;
import week3.behavioral.cor.ChainBuilder;
import week3.behavioral.cor.PurchaseRequest;

public class ChainOfResponsibilityTest {

    @Test
    public void testChain() {
        final double base = 500;
        ChainBuilder<PurchaseRequest> chainBuilder = ChainBuilder.chainBuilder();
        Chain<PurchaseRequest> chain = chainBuilder
                .first(request -> {
                    if (request.getAmount() < base * 10) {
                        System.out.println("Manager will approve $" + request.getAmount());
                        return true;
                    }
                    return false;
                })
                .successor(request -> {
                    if (request.getAmount() < base * 20) {
                        System.out.println("Director will approve $" + request.getAmount());
                        return true;
                    }
                    return false;
                })
                .successor(request -> {
                    if (request.getAmount() < base * 50) {
                        System.out.println("President will approve $" + request.getAmount());
                    } else {
                        System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
                    }
                    return true;
                }).build();

        chain.handle(new PurchaseRequest(1000)); // manager
        chain.handle(new PurchaseRequest(9000)); // director
        chain.handle(new PurchaseRequest(23000)); // president
        chain.handle(new PurchaseRequest(100000)); // board
    }

}
