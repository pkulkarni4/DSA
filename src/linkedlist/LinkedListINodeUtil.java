package linkedlist;

public class LinkedListINodeUtil {
    public static LinkedListINode getLinkedListINode() {
        LinkedListINode head = new LinkedListINode(1);
        LinkedListINode node1 = new LinkedListINode(2);
        LinkedListINode node2 = new LinkedListINode(3);
        LinkedListINode node3 = new LinkedListINode(4);
        LinkedListINode node4 = new LinkedListINode(5);
        LinkedListINode node5 = new LinkedListINode(6);
        LinkedListINode node6 = new LinkedListINode(7);
        LinkedListINode node7 = new LinkedListINode(8);
        LinkedListINode node8 = new LinkedListINode(9);
        LinkedListINode node9 = new LinkedListINode(10);
        LinkedListINode node10 = new LinkedListINode(11);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        return head;
    }

    public static LinkedListINode get5LinkedListINode() {
        LinkedListINode head = new LinkedListINode(1);
        LinkedListINode node1 = new LinkedListINode(2);
        LinkedListINode node2 = new LinkedListINode(3);
        LinkedListINode node3 = new LinkedListINode(4);
        LinkedListINode node4 = new LinkedListINode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        return head;
    }

    public static LinkedListINode get3LinkedListINode() {
        LinkedListINode head = new LinkedListINode(0);
        LinkedListINode node1 = new LinkedListINode(1);
        LinkedListINode node2 = new LinkedListINode(2);

        head.next = node1;
        node1.next = node2;

        return head;
    }

    static void printLinkedListINode(LinkedListINode head) {
        LinkedListINode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static LinkedListINode getSortedLinkedListINodesWithDuplicates() {
        LinkedListINode head = new LinkedListINode(1);
        LinkedListINode node1 = new LinkedListINode(2);
        LinkedListINode node2 = new LinkedListINode(2);
        LinkedListINode node3 = new LinkedListINode(3);
        LinkedListINode node4 = new LinkedListINode(3);
        LinkedListINode node5 = new LinkedListINode(3);
        LinkedListINode node6 = new LinkedListINode(4);
        LinkedListINode node7 = new LinkedListINode(8);
        LinkedListINode node8 = new LinkedListINode(9);
        LinkedListINode node9 = new LinkedListINode(10);
        LinkedListINode node10 = new LinkedListINode(11);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        return head;
    }
}
