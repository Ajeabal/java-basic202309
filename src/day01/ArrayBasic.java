package day01;

import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        // 자바 배열 특징
        // 1. 동종 모음 구조 : 같은 타입의 데이터만 저장
        // 2. 크기가 고정됨 : 크기를 동적으로 늘이거나 줄일 수 없다

        // 배열 선언
        int[] arr;
        // 배열 생성
        arr = new int[5];

        // 배열 초기화
        arr[0] = 50;
        arr[1] = 77;
        arr[2] = arr[0] + 20;
        arr[3] = (int) 66.7;
        arr[4] = 100;
//        arr[5] = 60;
        // 배열의 길이
        System.out.println("arr.length = " + arr.length);

        // fori
        for (int i = 0; i < arr.length; i++) {
            System.out.println("데이터: " + arr[i]);
        }
        System.out.println("=====================");
        // iter
        for (int n : arr) {
            System.out.println("n = " + n);
        }

        // 문자열로 배열 내부 출력
        System.out.println(Arrays.toString(arr));

        // 배열 한번에 만들기
//        int[] numbers = new int[]{10, 20, 30};
        // 배열 변수 선언과 함께일 때는 new의 생략가능
        int[] numbers = {10, 20, 30};
        numbers = new int[]{40, 50, 60};
        System.out.println(Arrays.toString(numbers));
        System.out.println("=====================");
        // 배열을 생성만 하고 값을 안넣으면 기본값이 세팅됨
        byte[] bArr = new byte[3]; // 정수 기본값 0
        double[] dArr = new double[5]; // 실수 0.0
        boolean[] boArr = new boolean[4]; // 논리 false
        String[] sArr = new String[3]; // 그 외 null
        System.out.println(Arrays.toString(bArr));
        System.out.println(Arrays.toString(dArr));
        System.out.println(Arrays.toString(boArr));
        System.out.println(Arrays.toString(sArr));
    }
}
