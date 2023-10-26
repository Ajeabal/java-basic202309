package day11.map;

import day11.stream.Dish;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static day11.stream.Menu.menuList;
import static util.Utility.makeLine;

public class Mapping {
    private static class NameAndType{
        private String name;
        private Dish.Type type;

        public NameAndType(Dish dish) {
            this.name = dish.getName();
            this.type = dish.getType();
        }

        @Override
        public String toString() {
            return "NameAndType{" +
                    "name='" + name + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
    // 이름과 칼로리만 가지고 있는 클래스 설계
    private static class SimpleDish {
        private String name;
        private int calories;

        public SimpleDish(Dish dish) {
            this.name = dish.getName();
            this.calories = dish.getCalories();
        }

        public SimpleDish(String name, int calories) {
            this.name = name;
            this.calories = calories;
        }
        @Override
        public String toString() {
            return "SimpleDish{" +
                    "name='" + name + '\'' +
                    ", calories=" + calories +
                    '}';
        }
    }
    public static void main(String[] args) {

        // stream의 map: 컬렉션(리스트, 센, 맵...)에서 원하는 정보만 추출하여 새로운 컬렉션으로 반환

        List<Integer> nameList = menuList.stream()
                .map(Dish::getCalories)
                .collect(Collectors.toList());
        System.out.println(nameList);
        makeLine();
        /*
            요리 목록에서 메뉴 이름과 칼로리를 추출하고 싶다.
         */
        menuList.stream()
                .map(dish -> new SimpleDish(dish))
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x));
        makeLine();
        /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰 음식들을 필터링한 다음
            음식의 이름과 타입만 추출해서 출력
         */
        menuList.stream()
                .filter(dish -> dish.getCalories() > 500)
                .map(dish -> new NameAndType(dish))
                .collect(Collectors.toList())
                .forEach(nameAndType -> System.out.println(nameAndType));

    }
}
