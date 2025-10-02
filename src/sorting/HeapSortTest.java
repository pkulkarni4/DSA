package sorting;

public class HeapSortTest {
    public static void main(String[] args) {
        int[][] examples = {
                {20, 10, 20, 30, 20, 40},
                {5, 3, 1, 2, 4}
        };
        HeapSort sort = new HeapSort();
        for (int[] arr : examples) {
            sort.sort(arr);
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
