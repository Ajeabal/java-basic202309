package day11.inner;

// 람다가 사용할 수 있는지 체크 하는 방법
// 람다 사용 조건: 추상 메서드가 1개만 있어야 가능
@FunctionalInterface

public abstract interface Calculator {
    int operate(int n1, int n2);
}
