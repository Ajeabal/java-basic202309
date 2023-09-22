package day08.collection.map;

import day05.poly.car.Mustang;
import util.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        // key의 타입과 value의 타입
        Map<String, Object> map = new HashMap<>();

        // put(K, V): 데이터 추가
        map.put("지갑잔액", 5000);
        map.put("좋아하는 자동차", new Mustang());
        map.put("저녁메뉴", "계란말이");

        System.out.println(map.size());

        // get(key)
        int money = (int) map.get("지갑잔액");
        System.out.println(money);
        String dinner = (String) map.get("몰라");
        System.out.println(dinner);

        // 중복된 Key를 저장하면 값이 변경됨.
        map.put("저녁메뉴", "김치찌개");
        System.out.println(map);
        
        // map의 반복문 처리
        Set<String> keySet = map.keySet();
        System.out.println("KeySet = " + keySet);
        Utility.makeLine();
        for (String s : keySet) {
            System.out.printf("%s : %s\n", s, map.get(s));
        }

    }
}
