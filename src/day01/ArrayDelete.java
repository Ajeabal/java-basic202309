package day01;

import java.util.Arrays;

public class ArrayDelete {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int deleteTargetIndex = 2;

        for (int i = deleteTargetIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        System.out.println("arr = " + Arrays.toString(arr));

        arr[2] = arr[3];
        arr[3] = arr[4];
        arr[4] = arr[5];

        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        temp = null;

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("temp = " + Arrays.toString(temp));

    }
}
