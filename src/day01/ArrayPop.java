package day01;

import java.util.Arrays;

public class ArrayPop {
    public static void main(String[] args) {
        // pop: 맨 끝 데이터 삭제
        int[] arr = {10, 20, 30, 40, 50};

        // 새로운 배열을 생성 (기존 사이즈보다 1개 작은 배열)
        int[] temp = new int[arr.length - 1];
        // 맨 앞부터 순차적으로 새로운 배열에 복사
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }

        arr = temp;
        temp = null;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
    }
}
