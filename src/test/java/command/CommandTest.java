package command;

import org.junit.Test;
import week3.behavioral.command.Invoker;
import week3.behavioral.command.Receiver;

public class CommandTest {

    @Test
    public void testCommand() {
        final Invoker macro = new Invoker();
        final Receiver editor = new Receiver();

        macro.record(editor::open);
        macro.record(editor::save);

        macro.run(); // 3rd way

    }
}
