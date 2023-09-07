package day02;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {

        int korScore = 77;
        int engScore = 100;
        int mathScore = 99;

        int[] kimScores = {korScore, engScore, mathScore};
        int[] parkScores = {100, 22, 56};
        int[] hongScores = {40, 80, 90};

        // 2차원 배열
        int[][] classScores = {kimScores, parkScores, hongScores};

        /*
            {
                {77, 100, 99},
                {100, 22, 56},
                {40, 80, 90}
             }
         */
        System.out.println(classScores.length);
        System.out.println(classScores[0]);
        System.out.println(kimScores);
        System.out.println(Arrays.toString(classScores[0]));
        System.out.println(classScores[0][0]); // == kimScores[0]

        System.out.println(Arrays.toString(classScores));
        System.out.println(Arrays.deepToString(classScores));

        // 2차원 배열의 값 초기화
        int[][] arr2d = {
                {10, 20, 30},
                {40, 50, 60},
                {100, 200, 300},
                {400, 500, 600}
        };
        System.out.println(arr2d[2][2]);

        // 2차원 배열 순회 : iter
        for (int[] nums : arr2d) {
            for (int n : nums) {
                System.out.printf("%3d ", n);
            }
            System.out.println();
        }

        // 배열의 공간만 지정하고 생성 : 5행 4열의 배열을 공간만 생성하고 싶다.
        // 5행 : 2차원 배열에 들어갈 1차원 배열의 수
        // 4열 : 1차원 배열에 들어갈 데이터의 수
        int[][] array5by4 = new int[5][4];

        System.out.println("=============================");

        array5by4[3][2] = 99;

        for (int[] ints : array5by4) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }

        // 3차원 배열
        int[][][] arr3d = {
                {
                        {10, 20},
                        {30, 40}
                },
                {
                        {50, 60},
                        {70, 80}
                },
                {
                        {100, 200},
                        {500, 1000}
                }
        };
        System.out.println(arr3d[2][1][0]);

        for (int[][] ints : arr3d) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    System.out.println("i = " + i);
                }
            }
        }
    }
}
