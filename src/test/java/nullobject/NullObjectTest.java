package nullobject;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class NullObjectTest {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "Aizhan";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "Szabina";
        Optional<String> optionalName = Optional.ofNullable(name);
        assertTrue(optionalName.isPresent());
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> optionalName = Optional.ofNullable(name);
        assertFalse(optionalName.isPresent());
    }

    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Csikos");
        assertTrue(opt.isPresent());

        opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
        Optional<String> opt = Optional.of("Gabor");
        assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Aizhan");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Aizhan");
        assertEquals("Aizhan", name);
    }

    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "Aizhan");
        assertEquals("Aizhan", name);
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(
                IllegalArgumentException::new);
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("Aizhan");
        String name = opt.get();
        assertEquals("Aizhan", name);
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.get();
    }

    private String getMyDefault() {
        return "Default Value";
    }
}
