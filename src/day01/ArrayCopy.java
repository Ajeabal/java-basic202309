package day01;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        String[] pets = {"개", "고양이", "돼지"};

//        String[] petsCopy = new String[pets.length];
//        for (int i = 0; i < pets.length; i++) {
//            petsCopy[i] = pets[i];
//        }
        String[] petsCopy = Arrays.copyOf(pets, pets.length);

        petsCopy[0] = pets[0];
        petsCopy[1] = pets[1];
        petsCopy[2] = pets[2];

        pets[1] = "어흥이";

        System.out.println("pets = " + pets);
        System.out.println("petsCopy = " + petsCopy);

        System.out.println("pets = " + Arrays.toString(pets));
        System.out.println("petsCopy = " + Arrays.toString(petsCopy));
    }
}
