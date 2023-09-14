package day05.static_;

public class Count {
    // 제한자 (modifier)
    // 접근 제한자 (access), 사용 제한자 (usage)
    public static int x;
    public int y;

    // static안에서는 static만 직접 참조 가능
    // 인스턴스 필드는 객체를 명시적으로 밝혀야 가능하다.
    // 정적 메서드
    public static void m1(Count c) {
        System.out.println("static메서드");
        System.out.println("x = " + x);
        System.out.println("y = " + c.y);
    }

    // 인스턴스 메서드
    public void m2() {
        System.out.println("인스턴스");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
