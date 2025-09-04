package arrays;

public class RotateSortedArray implements RotateArray {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        print(arr);
        rotateAndPrintArray(arr, 1);
        rotateAndPrintArray(arr, 2);
        rotateAndPrintArray(arr, 3);
        rotateAndPrintArray(arr, 4);
        rotateAndPrintArray(arr, 5);
    }


    private static void rotateAndPrintArray(int[] arr, int k) {
        int res2[] = rotateArraySimpleWay(arr, arr.length, k);
        System.out.println("\narray rotated " + k + " times");
        print(res2);
    }

    private static int[] rotateArraySimpleWay(int[] arr, int len, int rotate) {
        int k = rotate % len;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[(i + k) % len] = arr[i];
        }

        return res;
    }

    private static void print(int[] res) {
        for (int i : res)
            System.out.print(i + " ");
    }

    @Override
    public int[] rotateArray(int[] arr, int k) {
        return rotateArraySimpleWay(arr, arr.length, k);
    }
}

interface RotateArray {
    int[] rotateArray(int[] arr, int k);
}
