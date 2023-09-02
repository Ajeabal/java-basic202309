package day01;

public class ArraySearch {
    public static void main(String[] args) {
        String[] foods = {"족발", "치킨", "파스타", "삼겹살"};

        String findTarget = "파스타";

        int index = -1;
        for (int i = 0; i < foods.length; i++) {
            if (findTarget == foods[i]){
                index = 1;
                break;

            }
        }
        System.out.println("index =" + index);
    }
}
