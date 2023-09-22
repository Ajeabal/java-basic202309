package day07.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryExample2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("정수1: ");
            int n1 = sc.nextInt(); // InputMismatchException

            System.out.print("정수2: ");
            int n2 = sc.nextInt(); // InputMismatchException

            int result = n1 / n2; // ArithmeticException
            System.out.println("result = " + result);
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력 해주세요");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다");
        } finally {
            System.out.println("이 코드는 항상 실행 됩니다.");
            sc.close();
        }
        System.out.println("프로그램 정상 종료");
    }
}
