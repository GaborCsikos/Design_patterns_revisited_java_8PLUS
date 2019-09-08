package week3.behavioral.memento;

public class CareTaker {

    public Memento saveToMemento(Life life) {
        return new Memento(life.getTime());
    }

    public Life restoreFromMemento(Memento memento) {
        return new Life(memento.getSavedTime());
    }

}
