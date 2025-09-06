package linkedlist;

import java.util.Stack;

/*
Problem: Consider a singly linked list of integers. Write a snippet of code that returns true if the linked list is a palindrome.
 */
public class FindPalindromeInLinkedList {
    public static void main(String[] args) {

        LinkedListINode head = LinkedListINodeUtil.getOddPalindromeLinkedList();
        LinkedListPalindromeSolution ss = new LinkedListPalindromeSolution();
        boolean b = ss.isPalindrome(head);
        LinkedListINodeUtil.printLinkedListINode(head);
        System.out.println("is Palindrome? " + b);
        System.out.println(" ---- ");
        LinkedListINode evenPalind = LinkedListINodeUtil.getEvenPalindromeLinkedList();
        boolean bPalind = ss.isPalindrome(evenPalind);
        LinkedListINodeUtil.printLinkedListINode(evenPalind);
        System.out.println("is Palindrome? " + bPalind);

        System.out.println(" ---- ");
        LinkedListINode notPalind = LinkedListINodeUtil.get5LinkedListINode();
        boolean no = ss.isPalindrome(notPalind);
        LinkedListINodeUtil.printLinkedListINode(notPalind);
        System.out.println("is Palindrome? " + no);
    }
}

class LinkedListPalindromeSolution {
    /*
    use stack to store elements up until middle of the linked list. start popping from stack once middle is reached.

     */
    public boolean isPalindrome(LinkedListINode head) {
        LinkedListINode slow = head;
        LinkedListINode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        // move fast one more step, if not null (this is for odd length)
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
