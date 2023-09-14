package day05.protec.pac1;

public class B {

    void test() {
        A a = new A();
        new A(1);
        new A("");

        a.f1 = 1;
        a.f2 = 2;

        a.m1();
        a.m2();
    }
}
