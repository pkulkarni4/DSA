package linkedlist;

/*
Problem: Consider an unsorted singly linked list of integers and a given integer, n.
Write a snippet of code that rearranges the nodes around n. In other words, by the end, the linked list will contain all the values that are less than n followed by all the nodes that are larger than n.
The order of the nodes can be altered and n itself can be anywhere between the values that are larger than n.

Ex:
head = 1 -> 5 -> 4 -> 3 -> 2 -> 7 -> null, val = 3
output
head = 1 -> 2 -> 3 -> 5 -> 4 -> 7 -> null
 */
public class RearrangingLinkedList {
    public static void main(String[] args) {
        LinkedListINode head = LinkedListINodeUtil.getLinkedListINode();
        RearrangingLinkedListSolution ss = new RearrangingLinkedListSolution();
        LinkedListINodeUtil.printLinkedListINode(ss.rearrange(head, 3));
    }
}

class RearrangingLinkedListSolution {

    public LinkedListINode rearrange(LinkedListINode head, int val) {
        // if curr.data < 3, then it goes to left
        // otherwise, it goes to right
        // then combine left and right
        LinkedListINode curr = head;
        LinkedListINode left = null;
        LinkedListINode right = null;

        while (curr != null) {
            LinkedListINode nextNode = curr.next;
            if (curr.data < val) {
               // System.out.println("in left: " + curr.data);
                curr.next = left;
                left = curr;
            } else if (curr.data > val) {
                //System.out.println("in right: "+ curr.data);
                curr.next = right;
                right = curr;
            }
            curr = nextNode;
        }

        LinkedListINode valNode = new LinkedListINode(val);
        valNode.next = right;

        LinkedListINode leftTemp = left;
        while(leftTemp.next!=null){
            leftTemp = leftTemp.next;
        }
        leftTemp.next = valNode;
        LinkedListINode result = new LinkedListINode();
        result.next = left;

        head = result.next;

        return head;
    }
}