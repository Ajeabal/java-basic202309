package day11.lamda;

@FunctionalInterface
public interface GenericFunction<X, Y> {

    // X에서 Y를 추출하자
    Y apply(X x);
}
