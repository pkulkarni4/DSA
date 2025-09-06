package linkedlist;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbersSolution ss = new AddTwoNumbersSolution();
        LinkedListINode l1 = LinkedListINodeUtil.get5LinkedListINode();
        LinkedListINode l2 = LinkedListINodeUtil.get5LinkedListINode();
        System.out.println("Adding following: ");
        LinkedListINodeUtil.printLinkedListINode(l1);
        System.out.println(" And ");
        LinkedListINodeUtil.printLinkedListINode(l2);

        LinkedListINode sum = ss.addTwoNumbers(l1, l2);
        LinkedListINodeUtil.printLinkedListINode(sum);
    }
}

class AddTwoNumbersSolution {
    public LinkedListINode addTwoNumbers(LinkedListINode l1, LinkedListINode l2) {
        LinkedListINode p = l1;
        LinkedListINode q = l2;
        int carry = 0;
        LinkedListINode sum = addTwoNums(p, q, carry);
        return sum;
    }

    LinkedListINode addTwoNums(LinkedListINode p, LinkedListINode q, int carry) {
        // base case
        if (p == null && q == null && carry == 0) return null;

        int pVal = p == null ? 0 : p.data;
        int qVal = q == null ? 0 : q.data;
        int sum = pVal + qVal + carry;
        LinkedListINode sumNode = new LinkedListINode(sum % 10);

        sumNode.next = addTwoNums(p == null ? null : p.next, q == null ? null : q.next, sum >= 10 ? 1 : 0);
        return sumNode;
    }

}
