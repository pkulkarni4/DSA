package stacksqueues;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);

        Integer element = stack.peek();
        System.out.println("Element on stack top: " + element);

        Integer pos = stack.search(element);

        if (pos != -1) {
            System.out.println(element + " was found at position: " + pos);
        } else {
            System.out.println(element + " was not found");
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
