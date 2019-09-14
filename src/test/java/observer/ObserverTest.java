package observer;

import org.junit.Test;
import week4.behavioral.observer.Subject;

//(name, name2)
public class ObserverTest {

    @Test
    public void testObserver() {
        final Subject moon = new Subject();

        moon.startSpying(name -> {
            if (name.contains("HUN")) {
                System.out.println("We made it!");
            }
        });

        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("They're distracted, lets invade earth!");
            }
        });

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }
}
