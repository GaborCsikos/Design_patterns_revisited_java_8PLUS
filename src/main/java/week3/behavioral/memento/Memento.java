package week3.behavioral.memento;

public class Memento {
    private final String time;

    public Memento(String timeToSave) {
        time = timeToSave;
    }

    public String getSavedTime() {
        return time;
    }

}
