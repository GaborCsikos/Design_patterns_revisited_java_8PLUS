package week3.cor;

public interface Handler<T> {
    boolean handle(T t);
}