package stacksqueues;

import java.util.Stack;

/*
Consider you've been given a string representing a number of n digits.
Write a snippet of code that prints the smallest possible number after removing the given k digits.
The relative order of the digits from the same array must be preserved.

Example:
String num = 4514327, k = 4
answer: 127.
After removing 4 numbers - 4543 from
*/
public class SmallestNumber {
    public static void main(String[] args) {
        SmallestNumberSolution ss = new SmallestNumberSolution();
        ss.smallestNumber("4514327", 4);
    }
}

class SmallestNumberSolution {

    /*
    solution uses monotonic stack that either only smaller or larger number
     */
    public void smallestNumber(String nr, int k) {

        if (nr == null || k <= 0) return;
        int length = nr.length();
        if (k >= length) {
            System.out.println("The number is: " + 0);
            return;
        }

        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < length) {
            // if the current digit is less than the previous
            // digit then discard the previous one
            while (k > 0 && !stack.isEmpty()
                    && stack.peek() > nr.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(nr.charAt(i));
            i++;
        }

        // cover corner cases such as '2222'
        while (k > 0) {
            stack.pop();
            k--;
        }

        System.out.println("The number is (as a printed stack; "
                + "ignore leading 0s (if any)): " + stack);

    }
}
