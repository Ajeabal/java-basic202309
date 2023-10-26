package day11.lamda;

import java.util.ArrayList;
import java.util.List;

public class MappingApple {

    // 사과의 색상만 추출하는 메서드
    public static List<Color> mappingAppleByColor(List<Apple> apples) {
        List<Color> colorList = new ArrayList<>();
        for (Apple a : apples) {
            Color color = a.getColor(); // 사과에서 색을 추출
            colorList.add(color); // 색상 리스트에 넣음
        }
        return colorList;
    }

    public static <X,Y> List<Y> map(List<X> apples, GenericFunction<X, Y> mapper) {
        List<Y> mappedList = new ArrayList<>();
        for (X x : apples) {
            Y y = mapper.apply(x); // Y를 추출 <- 이 동작을 파라미터화 하자.
            mappedList.add(y); // 매핑리스트에 넣음
        }
        return mappedList;
    }
}
