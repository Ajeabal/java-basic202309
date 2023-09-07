package day01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] members = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};
        System.out.println("* 변경 전 정보: " + Arrays.toString(members));
        while (true) {
            System.out.println("- 수정할 멤버의 이름을 입력하세요.");
            System.out.print(">> ");
            String memberName = sc.nextLine();
            for (int i = 0; i < members.length; i++) {
                if (memberName.equals(members[i])) {
                    System.out.printf("%s의 별명을 변경합니다.\n", memberName);
                    System.out.print(">> ");
                    String changeName = sc.nextLine();
                    members[i] = changeName;
                    System.out.println("변경완료!!");
                    System.out.println("* 변경 후 정보: " + Arrays.toString(members));
                    return;
                }
            }
            System.out.printf("%s은(는) 없는 이름입니다.\n", memberName);
        }
    }
}
