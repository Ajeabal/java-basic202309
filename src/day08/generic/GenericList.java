package day08.generic;

import java.util.Arrays;

public class GenericList<V> {

    // 스트링 배열을 필드로 등록
    Object[] Arr;

    // 생성자를 통해 배열을 초기화
    public GenericList() {
        Arr = new Object[0];
    }
    GenericList(V... initData) {
        Arr = new Object[initData.length];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = initData[i];
        }
    }

    // 배열 맨 끝데이터 제거 후 삭제된 데이터 리턴
    V pop() {
        Object deleteDatum = Arr[Arr.length - 1];

        Object[] temp = new Object[Arr.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Arr[i];
        }
        Arr = temp;

        return (V) deleteDatum;
    }

    void printArray() {
        System.out.println(Arrays.toString(Arr));
    }

    // 배열에 저장된 데이터 수를 알려주는 기능
    public int size() {
        return Arr.length;
    }

    // 배열에 맨 끝에 데이터를 추가하는 기능
    public void push(V newData) {
        Object[] temp = new Object[Arr.length + 1];
        for (int i = 0; i < Arr.length; i++) {
            temp[i] = Arr[i];
        }
        temp[temp.length - 1] = newData;
        Arr = temp;
    }
    // 배열이 비어있는지 확인
    boolean isEmpty() {
        return Arr.length == 0;
    }
    // 배열을 전체 삭제하는 메서드
    void clear() {
        Arr = new Object[0];
    }

    // 인덱스 탐색 (indexOf)
    public int indexOf(V target) {
        for (int i = 0; i < Arr.length; i++) {
            if (target.equals(Arr[i])) {
                return i;
            }
        }
        return -1;
    }

    // 자료 유무 확인 (includes)
    public boolean includes(V target) {
        return indexOf(target) != -1;
    }

    // 중간 삭제 (remove) : 인덱스로 삭제
    public V remove(int index) {
        if (index < 0 || index > Arr.length - 1) return null;

        Object targetData = Arr[index];
        for (int i = index; i < Arr.length - 1; i++) {
            Arr[i] = Arr[i + 1];
        }
        pop();
        return (V) targetData;
    }
    // 중간 삭제 (remove) : 값으로 삭제
    public V remove(V target) {
        return remove(indexOf(target));
    }

    // 중간 삽입 (insert)
    public void insert(int index, V newData) {

        if (index < 0 || index > Arr.length - 1) return;
        if (index == Arr.length - 1) push(newData);

        Object[] temp = new Object[Arr.length + 1];
        for (int i = 0; i < Arr.length; i++) {
            temp[i] = Arr[i];
        }
        for (int i = temp.length - 1; i > index; i--) {
            temp[i] = temp[i-1];
        }
        temp[index] = newData;
        Arr = temp;
    }

    public Object[] getArr() {
        return Arr;
    }
}
