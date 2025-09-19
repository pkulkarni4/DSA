package medium;

import java.util.List;

public class Util {

    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i : arr){
            System.out.print(i +", ");
        }
        System.out.print("]\n");
    }

    public static void printAList(List<Integer> arr) {
        System.out.print("[");
        for(Integer i : arr){
            System.out.print(i +", ");
        }
        System.out.print("]\n");
    }

    public static void printArray(String msg, int[][] arr) {
        System.out.println(msg);
        printArray(arr);
    }

    public static void printArray(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        System.out.print("[");
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println(" ");
        }
        System.out.print("]\n");
    }
    public static void printArray(boolean[][] arr) {
        int m = arr.length, n = arr[0].length;
        System.out.print("[");
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println(" ");
        }
        System.out.print("]\n");
    }
}
