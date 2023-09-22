package day09.api.strbuilder;

public class StrBuilder {

    private static void makeString() {
        long start = System.currentTimeMillis();

        String s = "A";
        for (int i = 0; i < 200000; i++) {
            s += "A";
        }
        long end = System.currentTimeMillis();

        System.out.println("총 소요시간: " + (end - start) + "ms");
    }
    private static void makeStringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("A");
        for (int i = 0; i < 200000; i++) {
            s.append("A");
        }
        long end = System.currentTimeMillis();

        System.out.println("총 소요시간: " + (end - start));
    }

    public static void main(String[] args) {
        makeString();
        makeStringBuilder();
    }
}
