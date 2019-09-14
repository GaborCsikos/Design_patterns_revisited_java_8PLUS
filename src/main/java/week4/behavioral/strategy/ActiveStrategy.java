package week4.behavioral.strategy;

public class ActiveStrategy implements Strategy {

    @Override
    public String performTask() {
        return "Active";
    }
}