package day11.stream;

import util.Utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static day11.stream.Menu.*;
import static java.util.stream.Collectors.*;
import static util.Utility.*;

public class Filtering {
    public static void main(String[] args) {
        // stream의 filter
        // 필터조건에 맞는 데이터들을 필터링하여 리스트로 반환

        // 메뉴중에 채식주의자가 먹을 수 있는 요리를 필터링
//        List<Dish> dishInVegetarian = menuList.stream()
//                .filter(dish -> dish.isVegeterian())
//                .collect(Collectors.toList());
//        dishInVegetarian.forEach(dish -> System.out.println("dish = " + dish));
        menuList.stream()
                .filter(dish -> dish.isVegeterian())
                .collect(toList())
                .forEach(dish -> System.out.println("dish = " + dish));

        makeLine("육류이면서 600 칼로리 미만");
        menuList.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT && dish.getCalories() < 600)
                .collect(toList())
                .forEach(dish -> System.out.println("dish = " + dish));

        makeLine("요리중에 이름의 글자가 4글자인 요리");
        menuList.stream()
                .filter(dish -> dish.getName().length() == 4)
                .collect(toList())
                .forEach(dish -> System.out.println("dish = " + dish));

        makeLine("요리중에 300칼로리보다 큰 요리만");
        menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList())
                .forEach(dish -> System.out.println("dish = " + dish));
        makeLine();
        menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList())
                .forEach(dish -> System.out.println("dish = " + dish));
        makeLine("메늎 목록에서 처음 등장하는 2개의 생선요리 필터링");
        menuList.stream()
                .filter(dish -> dish.getType()== Dish.Type.FISH)
                .limit(2)
                .collect(toList())
                .forEach(dish -> System.out.println("dish = " + dish));
        makeLine();
        List<Integer> numbers = List.of(1,2,1,3,3,2,4,4,5,6);
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .collect(toList());
        // 중복 제거
        //Set<Integer> distinctNumbers = new HashSet<>(filteredNumbers);
        //System.out.println(distinctNumbers);
        System.out.println(filteredNumbers);
    }
}
