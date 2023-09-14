package day05.static_;

public class Calculator {
    String color;
    static double pi;

    static double calcAreaCircle(int r) {
        return pi * r * r;
    }

    // 계산기에 색을 칠하는 기능
    void paint(String color) {
        this.color = color;
    }
}
