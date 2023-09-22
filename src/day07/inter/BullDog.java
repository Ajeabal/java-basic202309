package day07.inter;

public class BullDog extends Livings implements BadAnimal {
    @Override
    public void hunt(Animal animal) {

    }

    @Override
    public void feed(String foodName) {

    }

    @Override
    public boolean sleep() {
        return false;
    }

    @Override
    public void angry() {

    }

    @Override
    public void makeHobby() {
        super.makeHobby();
    }
}
