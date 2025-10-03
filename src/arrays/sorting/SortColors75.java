package arrays.sorting;

public class SortColors75 {
    public static void main(String[] args) {
        int[][] examples = {
                {2,0,2,1,1,0},
                {2,0,1}
        };

        SortColors75Solution s = new SortColors75Solution();
        for(int[] example: examples) {
            s.sortColors(example);
            for(int i: example) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class SortColors75Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        for(int i = 0;i<len;i++){
            for(int j = i+1; j< len;j++){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j]= temp;
                }
            }
        }
    }
}