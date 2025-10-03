package arrays.sorting;

import java.util.Arrays;

import static medium.Util.printArray;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {9, 8, 6, 4, 3, 2, 1};
        input i = new input();
        i.setArr(arr);
        i.setTarget(11);
        //  BubbleSort s = new BubbleSort();
        SelectionSort s = new SelectionSort();
        s.sort(i);
        for (int a : i.getArr()) {
            System.out.print(a + " ");
        }
        ///
        System.out.println();
        Arrays.sort(arr);
        for (int a : i.getArr()) {
            System.out.print(a + " ");
        }
    }
}

class input {
    int[] arr;
    int target;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}

interface Sort {
    void sort(input in);

    default void swapVal(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

class SelectionSort implements Sort {
    public void sort(input in) {
        int[] arr = in.getArr();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swapVal(arr, i, min);
        }
        in.setArr(arr);
    }
}

class InsertionSort implements Sort {
    public void sort(input in) {

    }
}

class BubbleSort implements Sort {
    public void sort(input in) {
        int[] arr = in.getArr();
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapVal(arr, j, j + 1);
                }
            }
        }
        in.setArr(arr);
    }
}
