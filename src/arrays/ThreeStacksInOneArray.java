package arrays;

/*
Problem: Write an implementation of three stacks using a single array. The implementation should expose three methods: push(), pop(), and printStacks().
 */
public class ThreeStacksInOneArray {
    public static void main(String[] args) {
        ThreeStack ts = new ThreeStack();

        // 1 - this is the first stack
        // 2 - this is the second stack
        // 3 - this is the third stack

        // push 2, 12 and 5 in the second stack
        ts.push(2, 2);
        ts.push(2, 12);
        ts.push(2, 5);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // push 91, 21 in the third stack and pop from the second stack
        ts.push(3, 91);
        ts.push(3, 21);
        int sn = ts.pop(2);
        System.out.println("\nPop from second stack: " + sn);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // push 23, 11 and 3 in the first stack
        ts.push(1, 23);
        ts.push(1, 11);
        ts.push(1, 3);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // pop one node from each stack
        int sn1 = ts.pop(1);
        int sn2 = ts.pop(2);
        int sn3 = ts.pop(3);
        ts.printStacks();

        System.out.println();
        System.out.println("Pop: " + sn1);
        System.out.println("Pop: " + sn2);
        System.out.println("Pop: " + sn3);
    }
}

interface MultiStack {
    void push(int stack, int val);

    int pop(int stack);

    void printStacks();
}

class StackListNode {
    int value;
    int backLink;

    public StackListNode(int value, int backLink) {
        this.value = value;
        this.backLink = backLink;
    }
}

class ThreeStack implements MultiStack {

    int[] data;

    @Override
    public void push(int stack, int val) {

    }

    @Override
    public int pop(int stack) {
        return 0;
    }

    @Override
    public void printStacks() {

    }
}

class Stack {
    int[] data;
    int top, cap;

    Stack(int cap) {
        this.cap = cap;
        top = -1;
        data = new int[cap];
    }

    public void push(int val) {
        data[++top] = val;
    }

    public int pop () {
        return data[top--];
    }

    public int peek() {
        return data[top];
    }

}