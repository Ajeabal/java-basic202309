package day11.lamda;

import util.Utility;

import java.util.*;

import static day11.lamda.Color.*;
import static day11.lamda.FilterApple.filter;

public class Main {
    public static void main(String[] args) {
        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );
        System.out.println("==============녹색 사과==============");
        List<Apple> greenApples = FilterApple.fillterGreenApples(appleBasket);
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }
        System.out.println("==============다양한 색상 사과==============");
        List<Apple> fillteredApples = FilterApple.fillterApplesByColor(appleBasket, RED);
        for (Apple fillteredRedApple : fillteredApples) {
            System.out.println(fillteredRedApple);
        }
        System.out.println("==============원하는 조건 사과==============");
        List<Apple> apples1 = FilterApple.fillterApples(appleBasket, new LightApplePredicate());
        for (Apple apple : apples1) {
            System.out.println(apple);
        }
        Utility.makeLine();
        List<Apple> apples2 = FilterApple.fillterApples(appleBasket, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == RED || apple.getColor() == YELLOW;
            }
        });
        for (Apple apple : apples2) {
            System.out.println(apple);
        }
        Utility.makeLine("녹색이면서 100g 이상인 사과");
        // 녹색이면서 100g 이상인 사과들만 필터링
        List<Apple> apples3 = FilterApple.fillterApples(appleBasket,
                apple -> apple.getColor() == GREEN && apple.getWeight() >= 100
        );
        for (Apple apple : apples3) {
            System.out.println(apple);
        }
        Utility.makeLine("여러가지 필터링");
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> filter1 = filter(numbers, n -> n % 2 == 1);
        System.out.println(filter1);

        List<String> words = List.of("자장면", "짬뽕", "탕수육", "피자");
        List<String> filter2 = filter(words, s -> s.length() == 3);
        System.out.println(filter2);

        List<Apple> filter3 = filter(appleBasket, a -> a.getWeight() > 100 && a.getColor() == RED);
        System.out.println(filter3);

        Utility.makeLine("사과의 색상만 맵핑");
        List<Color> colorList = MappingApple.mappingAppleByColor(appleBasket);
        System.out.println(colorList);

        Utility.makeLine("숫자에서 제곱수를 맵핑");
        List<Integer> map1 = MappingApple.map(numbers, n -> n * n);
        System.out.println(map1);

        Utility.makeLine("문자에서 첫 글자만 맵핑");
        List<Character> map2 = MappingApple.map(words, s -> s.charAt(0));
        System.out.println(map2);

        Utility.makeLine("사과에서 무게만 맵핑");
        List<Integer> map3 = MappingApple.map(appleBasket, a -> a.getWeight());
        System.out.println(map3);
    }
}
