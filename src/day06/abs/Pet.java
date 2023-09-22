package day06.abs;

public abstract class Pet {

    private String name;
    private String kind;
    private int age;

    public Pet(String name, String kind, int age) {
        this.name = name;
        this.kind = kind;
        this.age = age;
    }

    public abstract void takeNap();

    public abstract void eat();

    public void walk() {}

    public final String info() {
        return "Hello!! " + name;
    }
}