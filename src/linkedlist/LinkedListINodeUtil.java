package linkedlist;

public class LinkedListINodeUtil {
    public static LinkedListINode getLinkedListINode() {
        LinkedListINode head = new LinkedListINode(1);
        LinkedListINode node1 = new LinkedListINode(2);
        LinkedListINode node2 = new LinkedListINode(6);
        LinkedListINode node3 = new LinkedListINode(3);
        LinkedListINode node4 = new LinkedListINode(4);
        LinkedListINode node5 = new LinkedListINode(5);
        LinkedListINode node6 = new LinkedListINode(6);
        LinkedListINode node7 = new LinkedListINode(2);
        LinkedListINode node8 = new LinkedListINode(7);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        return head;
    }

    static void printLinkedListINode(LinkedListINode head) {
        LinkedListINode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
