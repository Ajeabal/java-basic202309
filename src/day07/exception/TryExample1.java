package day07.exception;

public class TryExample1 {
    public static void main(String[] args) {
        int n1 = 10, n2 = 0; // 1

        System.out.println("나누기 시작"); // 2

        try {
            int result = n1 / n2; // 3
            System.out.printf("%d / %d = %d\n", n1, n2, result); //4
        } catch (Exception e) {
            // 에러가 나면 프로그램 종료 대신에 실행할 코드
            System.out.println("0으로 나눌 수 없습니다.");
            // 에러의 로그를 다시 띄우는 방법
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료"); // 5
    }
}
