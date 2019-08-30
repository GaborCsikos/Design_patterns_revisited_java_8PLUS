package week3.specification;

public interface Specification<T> {
    boolean isSatisfied(T item);
}