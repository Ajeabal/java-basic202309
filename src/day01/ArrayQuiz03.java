package day01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] students = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};
        System.out.println("* 우리반 학생들의 별명: " + Arrays.toString(students));
        while (true) {
            System.out.println("- 삭제할 학생의 별명을 입력하세요.");
            System.out.print(">> ");
            String delStudentsName = sc.nextLine();
            for (int i = 0; i < students.length; i++) {
                if (delStudentsName.equals(students[i])) {
                    System.out.printf("%s의 별명을 삭제합니다.\n", delStudentsName);
                    for (int j = i; j < students.length - 1; j++) {
                        students[j] = students[j+1];
                    }
                    String[] temp = new String[students.length - 1];
                    for (int j = 0; j < temp.length; j++) {
                        temp[j] = students[j];
                    }
                    students = temp;
                    temp = null;
                    System.out.println("* 삭제 후 정보: " + Arrays.toString(students));
                    return;
                }
            }
            System.out.printf("해당 별명은(%s)은 존재하지 않습니다.\n", delStudentsName);
        }
    }
}
