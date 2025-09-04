package arrays.geeks4geeks;

public class CheckMajorityElement {
    public static void main(String[] args) {
        MajorityElementLinearSearch me = new MajorityElementLinearSearch();
        int arr[] = {1, 2, 3, 4, 4, 4, 4};
        boolean b = me.isMajority(arr, 4);
        System.out.println(b);
        MajorityElement e = new MajorityElementBinarySearch();
        b=e.isMajority(arr, 4);
        System.out.println("bin search: "+b);
    }
}
interface MajorityElement{
    boolean isMajority(int[] arr, int target);
}

// O(n)
class MajorityElementLinearSearch implements MajorityElement {
    public boolean isMajority(int[] arr, int target){
        int length = arr.length;
        for(int i = 0; i< length; i++){
            if(arr[i] == target && arr[i+ length/2] == target) return true;
        }
        return false;
    }
}

// O(log n)
class MajorityElementBinarySearch implements MajorityElement{
    public boolean isMajority(int[] arr, int target){
        int len = arr.length;
        int last = bsearch(arr, target, false);
        int first = bsearch(arr, target, true);

        System.out.println("last idx: " + last);
        System.out.println("first idx: " + first);

        int lastIdx =  bsearchLast(arr, target);
        int firstIdx = bsearchFirst(arr, target);

        System.out.println("last idx: " + lastIdx);
        System.out.println("first idx: " + firstIdx);

        return ((lastIdx - firstIdx + 1 ) >= len/2);
    }

    private int bsearchLast(int[] arr, int target) {
        int low = 0, high = arr.length, idx =-1;
        while(low<high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= target){
                if(arr[mid] == target){
                    idx = mid;
                }
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return idx;
    }
    private int bsearch(int[] arr, int target, boolean isFirstOccurence) {
        int low = 0, high = arr.length, idx =-1;
        while(low<high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= target){
                if(arr[mid] == target){
                    idx = mid;
                }
                if(isFirstOccurence)
                    low = mid+1;
                else
                    high = mid-1;
            }else{
                if(isFirstOccurence)
                    high = mid-1;
                else{
                    low = mid+1;
                }
            }
        }
        return idx;
    }
    private int bsearchFirst(int[] arr, int target) {
        int low = 0, high = arr.length, idx =-1;
        while(low<high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= target){
                if(arr[mid] == target){
                    idx = mid;
                }
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return idx;
    }
}
