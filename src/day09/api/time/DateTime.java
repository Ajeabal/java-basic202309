package day09.api.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date);
//
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);

        // 현재 날짜 정보 얻기 (연-월-일)
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);

        // 현재 시간 정보 얻기 (시:분:초.000000)
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);

        // 날짜 + 시간
        LocalDateTime nowDT = LocalDateTime.now();
        System.out.println("nowDT = " + nowDT);

        // 원하는 정보만 추출
        int year = nowDT.getYear();
        int month = nowDT.getMonthValue();
        System.out.println("month = " + month);

        // 원하는 날짜 만들기
        LocalDateTime localDateTime = LocalDateTime.of(2023, 9, 22, 1, 19);
        System.out.println("localDateTime = " + localDateTime);

        // 날짜 연산
        // 도서대여 시스템
        // 대출날짜 오늘 -> 반납날짜는 17일 뒤
        LocalDateTime rentalDate = LocalDateTime.now();
        LocalDateTime targetDate = rentalDate.plusYears(1)
                .plusMinutes(6)
                .plusDays(28);
        System.out.println("targetDate = " + targetDate);

        // 사이 날짜 구하기
        LocalDate b = LocalDate.of(2019, 12, 28);
        LocalDate d = LocalDate.of(2023, 9, 28);

        boolean after = nowDate.isAfter(b);
        System.out.println("after = " + after);

        long between = ChronoUnit.DAYS.between(b, d);
        System.out.println("between = " + between);

        // 날짜 포맷 바꾸기
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분");

        String format = nowDT.format(dateTimeFormatter);
        System.out.println("format = " + format);

    }
}
