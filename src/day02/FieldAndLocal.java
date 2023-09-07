package day02;

public class FieldAndLocal {
    int a; // 필드 : 초기화 하지 않아도 자동으로 기본값을 초기화

    void foo(int c) { // method int c도 지역변수
        int b = 10; // 지역 변수 : 반드시 초기화를 수동으로 해줘야 함.
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    } // method block
}// class block
