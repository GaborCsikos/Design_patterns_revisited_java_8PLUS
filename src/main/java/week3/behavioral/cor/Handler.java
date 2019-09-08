package week3.behavioral.cor;

public interface Handler<T> {
    boolean handle(T t);
}