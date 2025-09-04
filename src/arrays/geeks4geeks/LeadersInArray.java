package arrays.geeks4geeks;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{16,17,4,3,5,2};
        printLeaders2(arr, 6);
    }
    static void printLeaders2(int[] arr, int size) {//O(n)
        int max_so_far=arr[size-1];
        System.out.print(max_so_far +"\t");
        for (int i = size-2; i >= 0; i--) {
            if(arr[i] > max_so_far){
                max_so_far = arr[i];
                System.out.print(max_so_far +"\t");
            }
        }
    }
    static void printLeaders(int[] arr, int size){ //O(n^2)
        for(int i=0;i<size;i++){
            int j;
            for(j=i+1;j<size;j++){
                if(arr[i]<=arr[j]){
                    break;
                }
            }
            if(j==size){
                System.out.print(arr[i] +"\t");
            }
        }
    }
}
