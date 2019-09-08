package week3.behavioral.specification;

public interface Specification<T> {
    boolean isSatisfied(T item);
}