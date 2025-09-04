package chapter08;

/**
 * Consider a sorted array of n elements that allows duplicates. An index k is magic if array[k] = k. Find first magic index.
 */

public class MagicIndex {
    public static void main(String[] args) {
        int[] p = new int[]{-1, -1, 1, 4, 4, 4, 5, 5, 6, 6, 8, 11, 12, 12, 12, 15, 15, 20, 21, 21};
        //int[] p = {-1, -1, 0, 3, 3, 4, 7, 8};
        int len = p.length - 1;
/*
        for(int i =0;i<=len;i++){
            if(p[i] == i) {
                System.out.println("First index, i= "+i);
                break;
            }
        }

        for(int i =len;i>=0;i--){
            if(p[i] == i) {
                System.out.println("last index i= "+i);
                break;
            }
        }

        int idx = findFirstMagicIndex(p, len);
        System.out.println(idx);

        int lastIdx = findLastMagicIndex(p, len);
        System.out.println(lastIdx);
*/
        int index = find(p, 0, len);
        System.out.println("from the book: " + index);
    }

    static int findFirstMagicIndex(int[] p, int len) {
        return findFirstMagicIndex(p, 0, len);
    }

    static int findFirstMagicIndex(int[] p, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        int val = p[mid];
        int left = findFirstMagicIndex(p, start, mid - 1);
        if (left >= 0) return left;
        if (mid == val) return mid;
        return findFirstMagicIndex(p, mid + 1, end);

    }

    static int findLastMagicIndex(int[] p, int len) {
        return findLastMagicIndex(p, 0, len);
    }

    static int findLastMagicIndex(int[] p, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        int val = p[mid];
        int right = findLastMagicIndex(p, mid + 1, end);
        if (right >= 0) return right;
        if (mid == val) return mid;
        return findLastMagicIndex(p, start, mid - 1);
    }

    // from the book:
    static int find(int[] arr, int startIndex, int endIndex) {


        if (startIndex > endIndex) {
            return -1; // return an invalid index
        }

        int middleIndex = (startIndex + endIndex) / 2;   // halved the indexes
        int value = arr[middleIndex];                    // value of middle index


        // search from middle of the array to the left
        int leftIndex = find(arr, startIndex, Math.min(middleIndex - 1, value));
        //System.out.println(" start index: " + startIndex + " end index: " + endIndex + "  middle index : " + middleIndex + " value : " + value);

        if (leftIndex >= 0) {
            System.out.println("index : " + leftIndex);
            return leftIndex;
        }

        if (value == middleIndex) {                      // if the value and index are equal then this is a magic index
            return middleIndex;
        }

        // search from middle of the array to the right
      return find(arr, Math.max(middleIndex + 1, value), endIndex);
    }
}
