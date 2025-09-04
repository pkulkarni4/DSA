package leetcode;

public class TestOperation {
   public static void main(String[] args){
     int finVal =  finalValueAfterOperations(new String[] {"++X","++X","X++"});
     System.out.println(finVal);
   }
    public static int finalValueAfterOperations(String[] ops) {
        if(ops == null || ops.length == 0) return 0;
        int x = 0;
        for(String op:ops) {
            if(op.equals("++X") || op.equals("X++")) {
                x++;
            } else{
                x--;
            }
        }
        return x;
    }
}
