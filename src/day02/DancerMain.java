package day02;

public class DancerMain {
    public static void main(String[] args) {


        Dancer hong = new Dancer("홍박사", "틱톡커", Genre.STREET, DanceLevel.PRO);
        hong.stretch();
        hong.introduce();
        hong.dance();
    }
}
