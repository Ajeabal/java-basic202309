package day11.lamda;

@FunctionalInterface
public interface GenericPredicate<T> {
    boolean test(T t);
}
