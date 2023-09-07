package day02;

import java.util.Arrays;

public class MethodQuiz {

    static String[] foods = {"떡볶이", "치킨", "파스타"};
    static String[] userNames = {"홍길동", "고길동"};

    static void printFoods() {
        String[] foodsList = foods;
        System.out.println(Arrays.toString(foodsList));
    }

    static String[] push(String newData) {
        String[] temp = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[temp.length - 1] = newData;

        foods = temp;
        temp = null;
        return foods;
    }

    static int indexOf(String findIndex) {
        int index = 0;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(findIndex)) {
                index = i;
            } else {
                index = -1;
            }
        }
        return index;
    }

    static void remove(String newData) {
        int deleteTargetIndex = indexOf(newData);
        if (deleteTargetIndex == -1) {
            System.out.println("존재하지 않는 음식입니다");
        } else {
            for (int j = deleteTargetIndex; j < foods.length - 1; j++) {
                foods[j] = foods[j + 1];
            }
            String[] temp = new String[foods.length - 1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = foods[j];
            }
            foods = temp;
        }
    }

    static boolean include(String findFood) {
        boolean isIn = false;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(findFood)) {
                isIn = true;
                break;
            } else {
                isIn = false;
            }
        }
        return isIn;
    }

    static String[] makeNew(int size) {
        return new String[size];
    }

    static String[] copy(int more) {
        int newSize = foods.length + more;
        String[] temp = makeNew(newSize);

        int loopCount = (more > 0) ? newSize - 1 : newSize;
        for (int i = 0; i < loopCount; i++) {
            temp[i] = foods[i];
        }
        return temp;
    }

    static void insert(int targetIdx, String targetName) {
        String[] temp = copy(1);
        for (int i = temp.length - 1; i > targetIdx; i--) {
            temp[i] = temp[i - 1];
        }
        temp[targetIdx] = targetName;
        foods = temp;
    }


    static void modify(int changeIndex, String insertData) {
        foods[changeIndex] = insertData;
    }

    static void clear() {
        foods = new String[0];
    }

    public static void main(String[] args) {
        printFoods();
        push("라면");
        push("김치찌개");
        printFoods();

        // idx에 2가 리턴되어야 함.
        int idx = indexOf("파스타");
        System.out.println("idx = " + idx);
        // idx에 4가 리턴되어야 함.
        int idx2 = indexOf("김치찌개");
        System.out.println("idx2 = " + idx2);
        // idx에 -1이 리턴되어야 함.
        int idx3 = indexOf("짜장면");
        System.out.println("idx3 = " + idx3);

        remove("김치찌개"); // foods배열에서 김치찌개 제거
        printFoods();
        remove("망고"); // 존재하지 않는 음식명입니다 출력.

        boolean flag = include("파스타"); // 파스타 발견시 true 리턴
        boolean flag2 = include("양념치킨"); // 양념치킨 미발견시 false 리턴
        System.out.println(flag);
        System.out.println(flag2);
        insert(3, "파인애플"); // 3번 인덱스에 파인애플 삽입
        modify(2, "닭갈비");  // 2번 인덱스 데이터 닭갈비로 수정
        printFoods();
        clear();  // foods배열 모든 데이터 삭제
        printFoods();

    }
}
