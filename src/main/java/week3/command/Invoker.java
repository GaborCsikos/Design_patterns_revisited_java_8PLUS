package week3.command;

import java.util.ArrayList;
import java.util.List;

public final class Invoker {

    private final List<Command> commands;

    public Invoker() {
        this.commands = new ArrayList<>();
    }

    public void record(final Command command) {
        this.commands.add(command);
    }

    public void run() {
        this.commands.forEach(Command::perform);
    }

}