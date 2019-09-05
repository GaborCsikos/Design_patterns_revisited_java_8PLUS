package week3.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<Person> people = new ArrayList<>();

    public void broadcast(String source, String message) {
        for (Person person : people)
            if (!person.getName().equals(source))
                person.receive(source, message);
    }

    public void join(Person p) {
        String joinMsg = p.getName() + " joins the chat";
        broadcast("room", joinMsg);

        p.setRoom(this);
        people.add(p);
    }

    public void message(String source, String destination, String message) {
        people.stream()
                .filter(p -> p.getName().equals(destination))
                .findFirst()
                .ifPresent(person -> person.receive(source, message));
    }
}
