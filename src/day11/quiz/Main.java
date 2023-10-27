package day11.quiz;

import util.Utility;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static util.Utility.*;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>
        makeLine("2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).");
        List<Transaction> collect1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2021)
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .collect(toList());
        collect1.forEach(System.out::println);

        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        // List<String>
        // 거래목록에서 거래자들을 추출한담에 거래자안에 있는 도시이름을 추출
        // filter :  10개중에 조건에 맞는 3개를 필터링
        // map :  10개중에 10개를 가져오는데 조건에 맞게 추출
        makeLine("거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.");
        List<String> collect2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        collect2.forEach(System.out::println);

        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.
        // List<Trader>
        makeLine("Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.");
//        transactions.stream()
//                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
//                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        List<Trader> cambridge = transactions.stream()
                .map(tr -> tr.getTrader())
                .filter(td -> td.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(tr -> tr.getName()))
                .collect(toList());
        cambridge.forEach(System.out::println);

        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
        // List<String>
        makeLine("모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환");
        List<String> names = transactions.stream()
                .map(trs -> trs.getTrader().getName())
                .distinct()
                .sorted() // 문자나 숫자는 Comparator를 사용하지 않음
                .collect(toList());
        System.out.println("names = " + names);

        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        makeLine("Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?");
        boolean isMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("isMilan = " + isMilan);

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
        makeLine("Cambridge에 사는 거래자의 모든 거래액의 총합 출력.");
        int totalValues = transactions.stream()
                .filter(trs -> trs.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .mapToInt(trs -> trs.getValue())
                .sum();
        System.out.println("totalValues = " + totalValues);

        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
        makeLine("모든 거래에서 최고거래액은 얼마인가?");
        int max = transactions.stream()
                .mapToInt(trs -> trs.getValue())
                .max().getAsInt();
        System.out.println("max = " + max);

        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
        makeLine("가장 작은 거래액을 가진 거래정보 탐색");
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(transaction -> transaction.getValue()));
        Transaction tr  = min.get();
        System.out.println("tr = " + tr);
    }
}
