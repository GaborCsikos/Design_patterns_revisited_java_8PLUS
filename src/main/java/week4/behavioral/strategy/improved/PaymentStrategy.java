package week4.behavioral.strategy.improved;

public interface PaymentStrategy {

    static PaymentStrategy cashPayment() {
        int serviceCharge = 5;
        return amount -> amount + serviceCharge;
    }

    static PaymentStrategy creditCardPayment() {
        int serviceCharge = 5;
        int creditCardFee = 10;
        return amount -> amount + serviceCharge + creditCardFee;
    }

    static PaymentStrategy sameAsCash() {
        return new PaymentStrategy() {
            @Override
            public int pay(int amount) {
                int serviceCharge = 5;
                return amount + serviceCharge;
            }
        };
    }

    int pay(int amount);
}