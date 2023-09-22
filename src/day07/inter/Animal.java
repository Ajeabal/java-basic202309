package day07.inter;

// class: 객체를 만드는 설계도
// interface: 클래스를 만드는 명세서
public interface Animal {

//    int a; // 필드 선언 X
//    Animal() {} // 생성자 선언 X

    // 상수만 선언 가능
    String PET = "귀여운 동물";

    // 기능들의 명세
    void feed(String foodName);

    boolean sleep();

    default void makeHobby() {}
}
