package day09.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputExample {
    public static void main(String[] args) {

        String path = "C:\\Users\\cyci\\Desktop\\git\\java-basic202309\\src\\day03\\member\\MemberRepository.java";
        try (FileInputStream finput = new FileInputStream(path)) {
            int data = 0;
            while (data != -1) {
                data = finput.read();
                // write 아스키 출력 담당
                System.out.write((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
