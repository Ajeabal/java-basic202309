package day01;

import java.util.Arrays;

public class ArrayInsert {
    public static void main(String[] args) {
        int[] arr = {10, 20, 90, 100, 999, 2000};
        int newData = 50;
        int targetIndex = 2;

        // 20과 90사이에 50을 넣어보자
        int[] temp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        for (int i = arr.length; i > targetIndex; i--) {
            temp[i] = temp[i-1];
        }
        temp[targetIndex] = newData;

        arr = temp;
        temp = null;

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("temp = " + Arrays.toString(temp));
    }
}
