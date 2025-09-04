package others;

public class TestRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = nums.length - 1;
        printNums(nums, len, 0);
    }

    static void printNums(int[] nums, int len, int i) {
        if (i == len) {
            return;
        }
        if(nums[i]%2 == 0)
            System.out.print(nums[i] + " ");

        printNums(nums, len, i + 1);
//   System.out.print(nums[i] + " "); // for reverse print
    }
}
