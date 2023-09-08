package day03.player;

public class Main {
    public static void main(String[] args) {

        new Player();

        Player parking = new Player("주차왕파킹");
        Player fucking = new Player("욕설왕퍼킹");

        parking.attack(fucking);
        System.out.println("parking = " + parking);
        System.out.println("fucking = " + fucking);
    }
}
