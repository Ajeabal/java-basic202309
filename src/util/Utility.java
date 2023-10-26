package util;

import java.util.Scanner;

public class Utility {

    static Scanner sc = new Scanner(System.in);

    public static void makeLine() {
        System.out.println("==============================");
    }
    public static void makeLine(String message) {
        System.out.println("=========="+ message +"==========");
    }

    public static String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
