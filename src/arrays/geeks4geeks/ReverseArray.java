package arrays.geeks4geeks;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        //iReverseArray reverseArray = new ReverseArrayLoop();
        //reverseArray.reverseArray(arr);
        iReverseArray reverseArray = new ReverseArrayLoopInPlace();
        reverseArray.reverseArray(arr);

    }
}

interface iReverseArray {
    void reverseArray(int[] arr);
    default void printArray(int[] arr){
        for(int i: arr)
            System.out.print(i+"\t");
    }
}

class ReverseArrayLoopInPlace implements iReverseArray{

    public void reverseArray(int[] arr) {
        int length = arr.length;
        reverseArr(arr, 0, length-1);
    }

    void reverseArr(int[] arr, int start, int end) {
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        printArray(arr);
    }

    public void reverseArray1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i< length/2; i++){
            int temp = arr[i];
            arr[i]=arr[length-i-1];
            arr[length-i-1]=temp;
        }
        printArray(arr);
    }
}

class ReverseArrayLoop implements iReverseArray{
    public void reverseArray(int[] arr){
        int length = arr.length;
        int temp[] = new int[length];
        for (int i = 0; i< length; i++){
            temp[i]=arr[length-i-1];
        }

        printArray(temp);
        arr=temp;
    }
}
