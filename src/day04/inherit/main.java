package day04.inherit;

public class main {
    public static void main(String[] args) {
//        new Player("zz");

        Warrior w =new Warrior("주차왕파킹");
        Mage m = new Mage("충격왕쇼킹");
        Hunter h = new Hunter("요리왕쿠킹");

        System.out.println(w.getNickName());

        w.status();
        m.status();
        h.status();

        System.out.println("=====================================");

        new Student();

    }
}
