package arrays;

public class DeleteColToSort944 {
    public static void main(String[] args) {
        String[] example1 = {
                "abc",
                "bce",
                "cae"
        };
        DeleteColToSort944Solution sol = new DeleteColToSort944Solution();
        int del = sol.minDeletionSize(example1);
        System.out.println(del);
        String[] example2 = {"a", "b"};
        del = sol.minDeletionSize(example2);
        System.out.println(del);

        String[] example3 = {"zyx","wvu","tsr"};
        del = sol.minDeletionSize(example3);
        System.out.println(del);
    }
}

class DeleteColToSort944Solution {
    /*
    check col by col if chars are sorted or not, if not then increase count
     */
    public int minDeletionSize(String[] strs) {
        int delCount = 0;
        int size = strs.length;
        int len = strs[0].length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size - 1; j++) {
               // System.out.println("comparing chars: " + strs[j].charAt(i) + " and " + strs[j+1].charAt(i));
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    delCount++;
                    break;
                }
            }
        }

        return delCount;
    }
}
