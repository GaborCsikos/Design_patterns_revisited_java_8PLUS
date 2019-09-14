package week4.behavioral.strategy;

public class LazyStrategy implements Strategy {

    @Override
    public String performTask() {
        return "Lazy";
    }

}