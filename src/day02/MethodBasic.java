package day02;

public class MethodBasic {

    static int add(int n1, int n2) {
        return n1 + n2;
    }

    static void makeLine() {
        System.out.println("=====================");
    }

    // n개의 정수를 전달받아 총합을 구하는 합수
    static int addAll(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // 2개의 정수배열을 전달받아서
    // 들어있는 요소의 수가 더 많은 배열을 리턴하는 메서드
    static int[] compareNumbers(int[] arr1, int[] arr2) {
        return arr1.length > arr2.length ? arr1 : arr2;
    }

    // 2개의 정수를 전달받아서
    // 4개의 사칙연산 결과를 리턴
    static int[] operateAll(int n1, int n2) {

        return new int[] {
                n1 + n2,
                n1 - n2,
                n2 * n2,
                n1 / n2
        };
    }


    public static void main(String[] args) {

        // 함수: 코드블록의 기능적 표현
        // ex )  add(10, 20)
        // 메서드: 객체의 동작 표현
        // ex )  샤프계산기.add(10, 20)
        //       카시오계산기.add(20, 30)
        //       멍멍이.비보잉댄스(); // 멍멍이가 당황한다
        //       댄서.왈왈짖어(); // 댄서가 당황한다.

        // 자바는 모든것을 객체로 표현하고, 함수마저도 모두
        // 메서드로 처리한다.
        // 자바의 메서드는 클래스 내부에만 선언이 가능
        // 다른 메서드 안에서 선언할 수 없음.

        int result = add(50, 100);
        System.out.println("result = " + result);

        makeLine();

        int[] arr = {10, 20, 30};
        int r2 = addAll(arr);
        System.out.println("r2 = " + r2);

        int r3 = addAll(new int[]{50, 100, 900, 1000});
        System.out.println("r3 = " + r3);

        int r4 = addAll(5, 8, 99, 2000, 1, -50);
        System.out.println("r4 = " + r4);

        makeLine();

        compareNumbers(new int[]{1, 2}, new int[]{3, 4, 5});

        makeLine();
    }


}
