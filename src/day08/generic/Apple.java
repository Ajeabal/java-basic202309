package day08.generic;

public class Apple extends Object {

    private int sweet;

    public Apple(int sweet) {
        this.sweet = sweet;
    }

    @Override
    public String toString() {
        return "사과 당도 " + sweet;
    }
}
