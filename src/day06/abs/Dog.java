package day06.abs;

public class Dog extends Pet {

    public Dog(String name, String kind, int age) {
        super(name, kind, age);
    }

    @Override
    public void takeNap() {
        System.out.println("강아지 잠");
    }

    @Override
    public void eat() {
        System.out.println("강아지 밥");
    }
}
