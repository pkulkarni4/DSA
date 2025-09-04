package arrays.medium;

public class SearchInRotatedArray33 {
    public static void main(String[] args) {
        SolutionSearchInRotatedArray33 s = new SolutionSearchInRotatedArray33();
        int[] rotatedArray = new int[]{4,5,6,7,9,0,1,2,3};
        int target = 9;
      //  int idx = s.search(rotatedArray, target);
      //  System.out.println(target + " found at index: " + idx);

        int idx1 = s.searchIterative(rotatedArray, target);
        System.out.println(target + " found at index: " + idx1);
    }
}

class SolutionSearchInRotatedArray33 {
    public int searchIterative(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = (left + right ) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[left]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        if (nums[low] <= nums[mid]) {
            // left side is sorted and check if target falls in between
            if (target >= nums[low] && target < nums[mid]) {
                return binarySearch(nums, low, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, high, target);
            }
        }
        if (target > nums[mid] && target <= nums[high]) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return binarySearch(nums, low, mid - 1, target);
        }

    }
}
