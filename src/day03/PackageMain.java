package day03;

import day03.juice.*;

public class PackageMain {
    public static void main(String[] args) {
        Mango mango = new Mango();
        Banana banana = new Banana();

        day03.juice.Apple apple1 = new day03.juice.Apple();
        day03.fruit.Apple apple2 = new day03.fruit.Apple();
    }
}
