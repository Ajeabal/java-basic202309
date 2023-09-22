package day07.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsPractice {

    // 정수를 입력 받아 리턴하는 메서드
    public static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    // 문자열을 정수로 변환하는 기능
    public static int convert(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }

    public static void inputAndConvertNumber() {
        int n = 0;
        int m = 0;
        try {
            n = inputNumber();
            m = convert("a");
        } catch (NumberFormatException e) {
            System.out.println("문자만 입력");
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력");
        }
        System.out.println(n+m);

    }

    public static void main(String[] args) {
        inputAndConvertNumber();
    }

}
