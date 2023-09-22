package day08.generic;

import util.Utility;

public class Main {
    public static void main(String[] args) {
        Apple a1 = new Apple(10);
        System.out.println(a1);

        AppleBasket ab = new AppleBasket();
        ab.setApple(a1);
        Apple apple = ab.getApple();

        Banana b1 = new Banana();
//        ab.setApple(b1);
        BananaBasket bb = new BananaBasket();
        bb.setBanana(b1);

        Basket<Apple> appleBasket = new Basket<Apple>();
        appleBasket.setFruit(new Apple(7));
        Apple app = appleBasket.getFruit();

        Basket<Banana> bananaBasket = new Basket<>();
        bananaBasket.setFruit(new Banana());
        Banana banana = bananaBasket.getFruit();

        Basket<Peach> peachBasket = new Basket<>();

        Utility.makeLine();
        GenericList<String> sList = new GenericList<>();
        sList.push("짜장면");
        sList.push("볶음밥");
        sList.push("치킨");

        sList.printArray();

        GenericList<Integer> numbers = new GenericList<>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        numbers.printArray();

        GenericList<Apple> appleGenericList = new GenericList<>();
        appleGenericList.push(new Apple(17));
        appleGenericList.push(new Apple(11));
        appleGenericList.push(new Apple(8));
        appleGenericList.printArray();
    }
}
