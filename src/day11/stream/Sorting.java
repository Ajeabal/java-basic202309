package day11.stream;

import static day11.stream.Menu.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static util.Utility.*;

public class Sorting {
    public static void main(String[] args) {
        makeLine("칼로리 오름차");
        menuList.stream()
                .sorted(comparing(Dish::getCalories))
                .collect(toList())
                .forEach(System.out::println);

        makeLine("칼로리 내림차");
        menuList.stream()
                .sorted(comparing(Dish::getCalories).reversed())
                .collect(toList())
                .forEach(System.out::println);

        makeLine("칼로리 500 이하 top3 오름차");
        menuList.stream()
                .filter(dish -> dish.getCalories() < 500)
                .sorted(comparing(Dish::getCalories).reversed())
                .limit(3)
                .collect(toList())
                .forEach(System.out::println);
    }
}
