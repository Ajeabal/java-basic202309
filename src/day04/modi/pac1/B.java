package day04.modi.pac1;

public class B {

    public B() {
        A a = new A();
        new A(10);
//        new A("문자열");
        a.f1 = 1;
        a.f2 = 2;
//        a.f3 = 3;
        a.m1();
        a.m2();
//        a.m3();

    }
}
