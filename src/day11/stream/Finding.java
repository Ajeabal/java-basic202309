package day11.stream;

import day11.stream.Dish;
import day11.stream.Menu;

import java.util.Comparator;
import java.util.Optional;

import static day11.stream.Menu.*;

public class Finding {
    public static void main(String[] args) {
        boolean flag1 = menuList.stream()
                .anyMatch(dish -> dish.isVegeterian());
        System.out.println("flag1 = " + flag1);

        boolean flag2 = menuList.stream()
                .anyMatch(dish -> dish.getCalories() < 50);
        System.out.println("flag2 = " + flag2);

        boolean flag3 = menuList.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("flag3 = " + flag3);

        boolean flag4 = menuList.stream()
                .noneMatch(dish -> dish.getCalories() < 1000);
        System.out.println("flag4 = " + flag4);

        Optional<Dish> min = menuList.stream()
                .min(Comparator.comparing(d -> d.getCalories()));
        System.out.println("min = " + min);
    }
}
