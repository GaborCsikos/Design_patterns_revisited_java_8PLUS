package week4.behavioral.strategy;


public class StrategyOldWay {
    public String perform(Strategy strategy) {
        return strategy.performTask();
    }
}
