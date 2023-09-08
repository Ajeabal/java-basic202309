package day02.array;

import java.util.Arrays;

public class StringList {

    // 스트링 배열을 필드로 등록
    String[] sArr;

    // 생성자를 통해 배열 초기화
    StringList() {
        sArr = new String[0];
    }

    StringList(String... initData) {
        sArr = new String[initData.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = initData[i];
        }
    }

    void push(String newData) {
        String[] temp = new String[sArr.length + 1];
        for (int i = 0; i < sArr.length; i++) {
            temp[i] = sArr[i];
        }
        temp[temp.length - 1] = newData;
        sArr = temp;

    }

    void pop() {
        String[] temp = new String[sArr.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = sArr[i];
        }
        sArr = temp;
    }

    void insert(int targetIdx, String targetName) {
        String[] temp = new String[sArr.length + 1];
        for (int i = 0; i < sArr.length; i++) {
            temp[i] = sArr[i];
        }
        for (int i = sArr.length; i > targetIdx; i--) {
            temp[i] = temp[i - 1];
        }
        temp[targetIdx] = targetName;

        sArr = temp;
    }

    int indexOf(String newData) {
        int index = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals(newData)) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
    }

    void remove(String target) {
        int deleteTargetIndex = indexOf(target);
        if (deleteTargetIndex == -1) {
            System.out.println("존재하지 않음");
        } else {
            for (int j = deleteTargetIndex; j < sArr.length - 1; j++) {
                sArr[j] = sArr[j + 1];
            }
            String[] temp = new String[sArr.length - 1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = sArr[j];
            }
            sArr = temp;
        }
    }

    void remove(int target) {
        for (int j = target; j < sArr.length - 1; j++) {
            sArr[j] = sArr[j + 1];
        }
        String[] temp = new String[sArr.length - 1];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = sArr[j];
        }
        sArr = temp;
    }

    boolean includes(String findFood) {
        boolean isIn = false;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals(findFood)) {
                isIn = true;
                break;
            } else {
                isIn = false;
            }
        }
        return isIn;
    }

    void clear() {
        sArr = new String[0];
    }

    boolean isEmpty() {
        return sArr.length == 0;
    }

    int size() {
        return sArr.length;
    }

    void printArray() {
        System.out.println(Arrays.toString(sArr));
    }

}
