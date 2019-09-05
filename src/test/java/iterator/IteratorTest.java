package iterator;

import org.junit.Test;
import week3.iterator.IterableCreature;

public class IteratorTest {

    @Test
    public void testIteraor() {
        IterableCreature creature = new IterableCreature();
        creature.setStrength(10);
        creature.setAgility(11);
        creature.setIntelligence(13);

        System.out.println("In forEach");
        creature.forEach(System.out::println);
        System.out.println("Spliterator");
        creature.spliterator().forEachRemaining(System.out::println);
        System.out.println("In forEach");
        for (Integer stats : creature) {
            System.out.println(stats);
        }

    }
}
