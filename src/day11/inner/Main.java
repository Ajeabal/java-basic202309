package day11.inner;

import day04.modi.pac2.C;

public class Main {

    public static class SubCalculator implements Calculator {
        @Override
        public int operate(int n1, int n2) {
            return n1 - n2;
        }
    }

    public static class Cat implements Pet {

        @Override
        public void eat() {

        }

        @Override
        public void play() {

        }
    }

    public static void main(String[] args) {
        AddCalculator cal1 = new AddCalculator();
        int r1 = cal1.operate(10, 20);
        System.out.println("r1 = " + r1);

        Calculator cal2 = new SubCalculator();
        int r2 = cal2.operate(30, 25);
        System.out.println("r2 = " + r2);

        Calculator cal3 = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        int r3 = cal3.operate(5, 8);
        System.out.println("r3 = " + r3);

        // lambda: 인터페이스의 추상메서드가 단 하나 일 때만 가능
        Calculator cal4 = (n1, n2) -> n1 / n2;

        int r4 = cal4.operate(20, 10);
        System.out.println("r4 = " + r4);

        Pet Shark = new Pet() {
            @Override
            public void eat() {

            }

            @Override
            public void play() {

            }
        };
    }
}
