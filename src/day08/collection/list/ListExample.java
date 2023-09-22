package day08.collection.list;

import day05.poly.Computer;
import day08.generic.Apple;
import util.Utility;

import java.util.*;

import static util.Utility.makeLine;

public class ListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // add(E e): 맨 끝에 데이터를 추가함.
        list.add("짜장면");
        list.add("짬뽕");
        list.add("파스타");
        list.add("리조또");
        list.add("치킨");

        System.out.println(list);

        // 장간삽입 add(index, E)
        list.add(2, "족발");
        System.out.println(list);

        int size = list.size();
        System.out.println("size = " + size);

        // indexOf(E e): 해당 데이터의 인덱스 반환
        int index = list.indexOf("파스타");
        System.out.println("index = " + index);
        
        // contains(E e): 해당 데이터에 저장 유무 반환
        System.out.println(list.contains("짜장면"));
        System.out.println(list.contains("마파두부"));

        // remove(index), remove(object)
        list.remove("파스타");
        list.remove(0);

        System.out.println(list);

        // set(index, newElement): 수정
        list.set(0, "동파육");
        System.out.println("list = " + list);

        //get(index): 리스트에 저장된 데이터 참조
        String s = list.get(1);
        System.out.println("s = " + s);


        // 반복문 처리
        makeLine();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        makeLine();
        for (String ss : list) {
            System.out.println("ss = " + ss);
        }
        // clear(): 전체 삭제
        // isEmpty(): 리스트 비었는지 확인
        makeLine();
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.isEmpty());

        // 리스트에 초기값 넣고 시작하기
        makeLine();
        List<Integer> numbers = new ArrayList<>(
                List.of(5, 30, 99, 11, 3, 2)
        );
        System.out.println(numbers);

        // 정렬
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);

        // 배열리스트와 연결리스트
        /*
                        탐색 속도    삽입 삭제 속도
            배열 리스트      빠름          느림
            연결 리스트      느림          빠름
        */
        List<Apple> appleList = new LinkedList<>();
        appleList.add(new Apple(18));

    }
}
