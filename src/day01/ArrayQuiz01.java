package day01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("# 먹고 싶은 음식을 입력하세요.");
        System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");
        String[] arr = {};
        while (true) {
            System.out.print(">> ");
            String fruit = sc.nextLine();
            if (fruit.equals("그만")) {
                break;
            }
            String[] temp = new String[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            temp[temp.length - 1] = fruit;
            arr = temp;
            temp = null;
        }
        System.out.println("먹고 싶은 음식 리스트 : "+Arrays.toString(arr));
    }
}
