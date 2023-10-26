package day11.lamda;

import java.util.ArrayList;
import java.util.List;

// 사과를 여러가지 방법으로 필터링
public class FilterApple {
    /**
     * @solution - try1 : 사과 바구니에서 녹색사과들만 필터링하자.
     * @problem - 만약에 다른 새깔의 사과를 필터링 해야 한다면
     *            새로운 매서드를 다시 만들어야 하는 문제가 있음
     * @param1 basket - 전체 사과가 들어 있는 바구니
     * @return - 녹색사과만 필터링된 바구니
     */
    public static List<Apple> fillterGreenApples(List<Apple> basket) {
        //녹색사과만 담을 바구니
        List<Apple> greenBasket = new ArrayList<>();
        for (Apple apple : basket) {
            if (apple.getColor() == Color.GREEN) {
                greenBasket.add(apple);
            }
        }
        return greenBasket;
    }
    /**
     * @solution - try2: 색상을 파라미터화 한다.
     */
    public static List<Apple> fillterApplesByColor(List<Apple> basket, Color color) {
        //필터된 사과만 담을 바구니
        List<Apple> filteredBasket = new ArrayList<>();
        for (Apple apple : basket) {
            if (apple.getColor() == color) {
                filteredBasket.add(apple);
            }
        }
        return filteredBasket;
    }
    /**
     * @solution - try3: 동작을 파라미터화 하면 해결된다.
     *                      ㄴ함수를 전달 받을 수 있다면.
     *                       ㄴ자바는 함수를 전달할 수 있나?
     *                        ㄴ불가능 자바의 함수는 일급 객체가 아닌다
     *                         ㄴ 함수 개념이 아니라 객체에 소속된 메서드의 개념
     *                        ㄴ그런데 전달되는 함수가 고정되어 있는가?
     *                         ㄴ필터조건에 따라 함수 내용이 다르다.
     *                          ㄴ그러면 어떻게 함수 이름이 통일되면서
     *                           ㄴ다른 내용을 전달할 수 있을까??
     *                            ㄴ오버라이딩 (상속, 인터페이스)
     *
     * @problem - 사과만 필터링 할 수 있음.
     *             ㄴ 다른 과일이나 전자제품은 필터링 불가능
     */
    public static List<Apple> fillterApples(List<Apple> basket, ApplePredicate predicate) {
        //필터된 사과만 담을 바구니
        List<Apple> filteredBasket = new ArrayList<>();
        for (Apple apple : basket) {
            if (predicate.test(apple)) {
                filteredBasket.add(apple);
            }
        }
        return filteredBasket;
    }
    /**
     * @solution - try4: 제너릭 필터 메서드 생성
     *
     */
    public static <T> List<T> filter(List<T> basket, GenericPredicate<T> predicate) {
        //필터된 사과만 담을 바구니
        List<T> filteredBasket = new ArrayList<>();
        for (T t : basket) {
            if (predicate.test(t)) {
                filteredBasket.add(t);
            }
        }
        return filteredBasket;
    }

}
