package day01;

import java.util.Scanner;

public class StdIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        System.out.print("나이 입력 : ");
        String inputAge = sc.nextLine();

        int age = Integer.parseInt(inputAge);

        int birthYear = 2023 - age + 1;

        System.out.printf("이름 %s, 나이: %s세 출생년도: %s년생\n", name, inputAge, birthYear);

        // 메모리 자원 해제 (하드웨어, 네트워크, 데이터베이스 외부장치 접근)
        sc.close();
    }
}
