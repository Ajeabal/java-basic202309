package day01;

public class VarScope {
    public static void main(String[] args) {
        // 자바는 블록 단위 스코프를 가짐
        int num1 = 1010;
        int num2 = 2020;
        
        // 자바는 변수가 생성된 블록을 이탈하면 메모리에서 삭제
        if (true) {
            int num3 = 3030;
            System.out.println("num1 = " + num3);
        }

        int num3 = 4040;
    }

}
