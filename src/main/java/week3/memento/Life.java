package week3.memento;

public class Life {
    private String time;

    public Life(String time) {
        this.time = time;
    }

    public void set(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}