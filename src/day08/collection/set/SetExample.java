package day08.collection.set;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // 빠르게 저장, 중복 제거, 순서 X
        // 인덱스, 키를 사용 안해서 개별탐색에는 불리함
        Set<String> footSet = new HashSet<>();

        // add(E e): 데이터 추가
        boolean f1 = footSet.add("김말이");
        footSet.add("닭꼬치");
        footSet.add("단무지");
        boolean f2 = footSet.add("김말이");
        footSet.add("김밥");

        System.out.println(footSet.size());
        System.out.println(footSet);
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        // remove(object)
        footSet.remove("단무지");
        System.out.println(footSet);

        // 데이터 중복을 빠르게 제거할 때 Set으로 변환
        List<Integer> numbers = new ArrayList<>(
                List.of(1,1,1,3,3,5,7,7,7,9,9,9,9)
        );
        System.out.println(numbers);
        Set<Integer> numberSet = new HashSet<>(numbers);
        System.out.println("numberSet = " + numberSet);
    }
}
