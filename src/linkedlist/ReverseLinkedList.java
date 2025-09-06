package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedListSolution ss = new ReverseLinkedListSolution();
        LinkedListINode ll = LinkedListINodeUtil.get5LinkedListINode();
        LinkedListINodeUtil.printLinkedListINode(ll);
        LinkedListINode head = ss.reverseLinkedList(ll);
        LinkedListINodeUtil.printLinkedListINode(head);
    }
}

class ReverseLinkedListSolution {
    LinkedListINode reverseLinkedList(LinkedListINode head) {
        LinkedListINode curr = head;
        LinkedListINode prev = null;
        while (curr != null) {
            LinkedListINode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}