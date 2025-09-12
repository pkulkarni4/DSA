package stacksqueues;

import java.util.LinkedList;
import java.util.Queue;

/*
see lc 1700 for desc and examples

 */
public class StudentsUnableToEatLunch1700 {
    public static void main(String[] args) {
        int[] students = {1,1,1,0};
        int[] sandwiches= {0,1,0,1};
        Solution1700 s = new Solution1700();
        int sts = s.countStudents(students, sandwiches);
        System.out.println(sts);
    }
}

class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int st: students){
            q.add(st);
        }
        int i = 0, count = 0;
        while(!q.isEmpty() && count < q.size()) {
            if(q.peek() == sandwiches[i]) {
                q.poll();
                i++;
                count = 0;
            } else {
                q.add(q.poll());
                count++;
            }
        }
        return q.size();
    }
}