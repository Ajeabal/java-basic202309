package day08.collection.song;

import day05.book.Book;
import util.Utility;

import java.util.*;

import static util.Utility.input;

public class ArtistView {

    private static ArtistRepository ar;
    private static Artist artist;

    static {
        ar = new ArtistRepository();
    }

    public static void start() {
        viewProcess();
    }

    static void mainView(int enteredArtists) {
        System.out.println("\n****** 음악 관리 프로그램 ******");
        System.out.println("# 현재 등록된 가수: " + enteredArtists + "명");
        System.out.println("# 1. 노래 등록하기");
        System.out.println("# 2. 노래 정보 검색");
        System.out.println("# 3. 프로그램 종료");
    }

    static void viewProcess() {
        while (true) {
            mainView(ar.enteredArtists());
            String menuNum = input(">>  ");
            switch (menuNum) {
                case "1":
                    System.out.println("\n# 노래 등록을 시작합니다.");
                    String name = input("- 가수명: ");
                    String song = input("- 노래명: ");
                    ar.addSong(name, song);
                    break;
                case "2":
                    System.out.println("\n# 검색할 가수명을 입력하세요");
                    String searchKeyWord = input("- 가수명: ");
                    ar.showSong(searchKeyWord);
                    break;
                case "3":
                    String answer = input("\n# 정말로 종료합니까? [y/n] : ");
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
}
