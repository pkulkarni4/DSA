package arrays.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 7, 7, 7, 8, 9};
        int target = 7;
        int idx = count(p, target);
        System.out.println(target + " exists " + idx + " times");
    }

    private static int count(int[] p, int i) {
        int lastIdx = bsearchLasstOccurance(p, i);
        int firstIdx = bsearchFirstOccurance(p, i);
        System.out.println("last idx: " + lastIdx + "   first idx:" + firstIdx);
        return lastIdx - firstIdx + 1;
    }

    private static int bsearchLasstOccurance(int[] p, int target) {
        int l = 0, u = p.length - 1, idx = -1;
        while (l <= u) {
            int m = (l + u) / 2;
            if(p[m] == target) {
                idx = m;
                l = m + 1;
            } else if (p[m] < target) {
                l = m + 1;
            } else {
                u = m - 1;
            }
        }
        return idx;
    }

    private static int bsearchFirstOccurance(int[] p, int target) {
        int low = 0, high = p.length - 1, idx = -1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (p[m] < target) {
                low = m + 1;
            } else {
                if (p[m] == target) {
                    idx = m;
                }
                high = m - 1;
            }
        }
        return idx;
    }
}
