package singleton;

import org.junit.Test;
import week1.cretional.singleton.BasicSingleton;
import week1.cretional.singleton.BestSingleton;
import week1.cretional.singleton.ShortestSingleton;

import static org.junit.Assert.assertEquals;

public class SingletonTest {

    @Test
    public void testEnum() {
        System.out.println("Running enum test");
        ShortestSingleton singleton = ShortestSingleton.INSTANCE;
        assertEquals(1, singleton.getCounter());

        ShortestSingleton singletonAgain = ShortestSingleton.INSTANCE;
        assertEquals(1, singletonAgain.getCounter());
    }

    @Test
    public void testBasicSingleton() {
        System.out.println("Running BasicSingleton test");
        BasicSingleton singleton = BasicSingleton.getInstance();
        assertEquals(1, singleton.getCounter());

        BasicSingleton singletonAgain = BasicSingleton.getInstance();
        assertEquals(1, singletonAgain.getCounter());
    }

    @Test
    public void testBestSingleton() {
        System.out.println("Running BestSingleton test");
        BestSingleton singleton = BestSingleton.getInstance();
        assertEquals(1, singleton.getCounter());

        BestSingleton singletonAgain = BestSingleton.getInstance();
        assertEquals(1, singletonAgain.getCounter());
    }
}
