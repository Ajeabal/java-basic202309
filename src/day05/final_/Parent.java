package day05.final_;

class Child extends Parent {

    int x;
//    @Override
//    public void sing() {
//        System.out.println("zzzz");
//    }

    @Override
    public void dance() {
        int a = 10;
    }
}

public class Parent {

    public final void sing() {
    }

    public void dance() {
    }
}
