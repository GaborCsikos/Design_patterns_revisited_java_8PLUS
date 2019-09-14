package strategy;

import org.junit.Test;
import week4.behavioral.strategy.ActiveStrategy;
import week4.behavioral.strategy.LazyStrategy;
import week4.behavioral.strategy.StrategyOldWay;
import week4.behavioral.strategy.improved.PaymentStrategy;

import static org.junit.Assert.assertEquals;

public class StrategyTest {

    private StrategyOldWay strategyOldWay = new StrategyOldWay();

    @Test
    public void testStrategy() {
        //Strategy lazy = new LazyStrategy();
        assertEquals("Active", strategyOldWay.perform(new ActiveStrategy()));
        assertEquals("Lazy", strategyOldWay.perform(new LazyStrategy()));
    }

    @Test
    public void testNewWay() {
        int price = 100;

        PaymentStrategy paymentStratgy = PaymentStrategy.cashPayment();
        assertEquals(105, paymentStratgy.pay(price));

        paymentStratgy = PaymentStrategy.creditCardPayment();
        assertEquals(115, paymentStratgy.pay(price));
    }
}
