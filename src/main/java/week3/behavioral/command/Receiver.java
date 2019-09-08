package week3.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public final class Receiver implements Editor {

    private final List<String> actions = new ArrayList<>();

    @Override
    public void close() {
        this.actions.add("close");
    }

    @Override
    public void open() {
        this.actions.add("open");
    }

    @Override
    public void save() {
        this.actions.add("save");
    }

}