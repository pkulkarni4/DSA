package stacksqueues;

import java.util.Stack;

/*
Consider you've been given a string representing a number of n digits.
Write a snippet of code that prints the smallest possible number after removing the given k digits.
The relative order of the digits from the same array must be preserved.
There should be no leading zeroes.

Example:
String num = 4514327, k = 4
answer: 127.
After removing 4 numbers - 4543 from
*/
public class SmallestNumber402 {
    public static void main(String[] args) {
        SmallestNumberSolution ss = new SmallestNumberSolution();
        String[] examples = {"4514327", "1432219", "100200", "10"};
        int[] k = {4, 3, 1, 2};
        for (int i = 0; i < examples.length; i++) {
            String smallNum = ss.smallestNumber(examples[i], k[i]);
            System.out.println(" example: " + examples[i] + " ==> " + smallNum);
        }
    }
}

class SmallestNumberSolution {

    /*
    solution uses monotonic stack that either only smaller or larger number
     */
    public String smallestNumber(String nr, int k) {

        if (nr == null || k <= 0) return "";

        int length = nr.length();

        if (k >= length) {
            //System.out.println("The number is: " + 0);
            return "0";
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

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.peek());
            stack.pop();
        }

        result = result.reverse();

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}
