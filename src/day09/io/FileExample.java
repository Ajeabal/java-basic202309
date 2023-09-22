package day09.io;

import java.io.File;
import java.io.IOException;

public class FileExample {

    // 파일 저장 기분 경로
    public static final String ROOT_PATH = "D:/";

    public static void main(String[] args) {

        // 폴더 생성
        // 파일정보 객체 생성
        File file = new File(ROOT_PATH + "/Hello");

        // 폴더 생성 명령
        if (!file.exists()) {
            file.mkdir();
        }

        // 파일 생성
        File f = new File(ROOT_PATH + "/Hello/food.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("파일 생성 실패");
            }
        }
    }
}
