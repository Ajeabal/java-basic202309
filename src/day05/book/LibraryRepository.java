package day05.book;

import static day05.book.RentStatus.*;
import static util.Utility.input;

public class LibraryRepository {
    // 회원 1명
    private static BookUser bookUser;

    // 도서들의 정보
    private static Book[] bookList;


    static {
        bookList = new Book[]{
                new CookBook("기적의 집밥책", "김해진", "청림라이프", true),
                new CartoonBook("떨어지면 끝장맨", "스에노부 케이코", "대원씨아이", 18),
                new CartoonBook("원펀맨", "One", "대원씨아이", 15),
                new CookBook("삐뽀삐뽀 119 이유식", "하정훈", "유니책방", false),
                new CookBook("오늘은 아무래도 덮밥", "이마이 료", "참돌", true),
                new CartoonBook("이세계로 전이했으니 치트를 살려 마법검사가 되기로 했다", "Shinkoshoto", "대원씨아이", 12)
        };
    }

    public void register(BookUser newUer) {
        bookUser = newUer;
    }

    void showAllBookList() {
        System.out.println("========== 모든 도서 정보 ==========");
        for (Book book : bookList) {
            System.out.println(book.info());
        }
    }

    RentStatus rentBook() {
        System.out.println("========== 대여 가능한 도서 정보 ==========");
        int beforeCoupon = bookUser.getCouponCount();
        int count = 1;
        for (Book book : bookList) {
            System.out.println(count + ". " + book.info());
            count++;
        }
        int rentNum = Integer.parseInt(input("- 대여할 도서 번호 입력: "));

        Book selectedBook = bookList[rentNum - 1];
        if (selectedBook instanceof CartoonBook) {
            CartoonBook cartoonBook = (CartoonBook) selectedBook;
            if (bookUser.getAge() > cartoonBook.getAccessAge()) {
                return RENT_SUCCESS;
            } else {
                return RENT_FAIL;
            }
        } else {
            CookBook cookBook = (CookBook) selectedBook;
            if (cookBook.isCoupon()) {
                bookUser.setCouponCount(beforeCoupon + 1);
                return RENT_SUCCESS_WITH_COUPON;
            } else {
                return RENT_SUCCESS;
            }
        }

    }

    void searchToTitle(String searchKeyWord) {
        int count = 0;
        System.out.printf("======== [%s] 검색 결과 ========\n", searchKeyWord);
        for (Book book : bookList) {
            if (book.getTitle().contains(searchKeyWord)) {
                System.out.println(book.info());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    void searchToName(String searchKeyWord) {
        int count = 0;
        System.out.printf("======== [%s] 검색 결과 ========\n", searchKeyWord);
        for (Book book : bookList) {
            if (book.getAuthor().equals(searchKeyWord)) {
                System.out.println(book.info());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void showMemberInfo() {
        System.out.println("******** 회원님 정보 ********");
        System.out.printf("# 회원명: %s\n", bookUser.getName());
        System.out.printf("# 나이: %s\n", bookUser.getAge());
        System.out.printf("# 성별: %s\n", bookUser.getGenderToString());
        System.out.printf("# 쿠폰개수: %s\n", bookUser.getCouponCount());
    }
}
