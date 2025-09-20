package arrays.greedy;

/*
LC: 55 - jump game

 */
public class JumpGame55 {
    public static void main(String[] args) {
        int[][] examples = {
                {3,2,2,0,3,0,1},
                {2,3,1,1,4},
                {3,2,1,0,4}
        };
        Solution55 s = new Solution55();
        for(int i =0;i<examples.length;i++){
            boolean b = s.canJump(examples[i]);
            System.out.println("can jump: " + b);
        }
    }
}
class Solution55 {
    public boolean canJump(int[] nums) {
        if(nums == null )return false;
        int len = nums.length;
        if(len == 0) return false;

        int maxReach = 0;
        for(int i =0;i<len;i++) {
            if(i>maxReach) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
        }
        return (maxReach >= len - 1);
    }
}
