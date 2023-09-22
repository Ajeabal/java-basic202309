package day05.book;

import java.util.Scanner;
import static day05.book.RentStatus.*;
import static util.Utility.input;

public class LibraryView {
    Scanner sc;
    private static LibraryRepository repository;

    public LibraryView() {
        repository = new LibraryRepository();
        this.sc = new Scanner(System.in);
        inputBookUser();
        viewProcess();
    }

    void inputBookUser() {
        System.out.println("# 회원 정보를 입력해주세요.");
        String name = input("# 이름: ");
        int age = Integer.parseInt(input("# 나이: "));
        Gender gender = checkCorrectGenderInput();
        BookUser bookUser = new BookUser(name, age, gender, 0);
        repository.register(bookUser);
    }

    void mainView() {
        System.out.println("\n=========== 도서 메뉴 ==========");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 제목으로 검색");
        System.out.println("# 4. 도서 대여하기");
        System.out.println("# 5. 도서 저자이름으로 검색");
        System.out.println("# 9. 프로그램 종료");
    }

    void viewProcess() {
        while (true) {
            mainView();
            String menuNum = input("- 메뉴 번호 : ");
            System.out.println("");
            switch (menuNum) {
                case "1":
                    repository.showMemberInfo();
                    break;
                case "2":
                    repository.showAllBookList();
                    break;
                case "3":
                    String searchKeyWord = input("# 검색어: ");
                    repository.searchToTitle(searchKeyWord);
                    break;
                case "4":
                    RentStatus rentStatus = repository.rentBook();
                    if (rentStatus == RENT_SUCCESS_WITH_COUPON) {
                        System.out.println("# 성공적으로 요리책이 쿠폰발급과 함께 대여되었습니다.");
                    } else if (rentStatus == RENT_SUCCESS) {
                        System.out.println("# 도서가 성공적으로 대여되었습니다.");
                    } else {
                        System.out.println("# 도서 대여에 실패했습니다.");
                    }
                    break;
                case "5":
                    String searchName = input("# 저자명: ");
                    repository.searchToName(searchName);
                    break;
                case "9":
                    String answer = input("# 정말로 종료합니까? [y/n] : ");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# 프로그램을 종료합니다.");
                        System.exit(0);
                    } else {
                        continue;
                    }
                    break;
                default:
            }

        }
    }

    private Gender checkCorrectGenderInput() {
        while (true) {
            String inputGender = input("# 성별 [M/F]: ");
            switch (inputGender.toUpperCase()) {
                case "M":
                    return Gender.MALE;
                case "F":
                    return Gender.FEMALE;
                default:
                    System.out.println("# 성별을 M또는 F로 입력하세요!");
            }
        }
    }
}
