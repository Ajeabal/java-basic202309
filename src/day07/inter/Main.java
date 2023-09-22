package day07.inter;

public class Main {
    public static void main(String[] args) {
        Animal duck = new Duck();
        BadAnimal bullDog = new BullDog();
        Huntable shark = new Shark();
        Violent rabbit = new Rabbit();
        
        Animal[] animals = {duck, (Animal) bullDog, (Animal) rabbit};
        
        for (Animal animal: animals) {
            animal.feed("맛도리 사료");
        }
    }
}
