package linkedlist;

/*
LC# 148: Sort List: Given the head of a linked list, return the list after sorting it in ascending order.

 */
public class SortLinkedList {
    public static void main(String[] args) {
        LinkedListINode head = new LinkedListINode(0);
        LinkedListINode n1 = new LinkedListINode(8);
        LinkedListINode n2 = new LinkedListINode(7);
        LinkedListINode n3 = new LinkedListINode(6);
        LinkedListINode n4 = new LinkedListINode(5);
        LinkedListINode n5 = new LinkedListINode(4);
        LinkedListINode n6 = new LinkedListINode(3);
        LinkedListINode n7 = new LinkedListINode(2);
        LinkedListINode n8 = new LinkedListINode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        SortLinkedList148Solution s = new SortLinkedList148Solution();
        LinkedListINode sorted = s.sortList(head);

        // print
        while (sorted != null) {
            System.out.print(sorted.data + " ");
            sorted = sorted.next;
        }
    }
}

class SortLinkedList148Solution {

    public LinkedListINode sortList(LinkedListINode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListINode[] headsOfSubLists = divide(head);
        LinkedListINode head1 = headsOfSubLists[0];
        LinkedListINode head2 = headsOfSubLists[1];

        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1, head2);
    }

    LinkedListINode[] divide(LinkedListINode sourceNode) {
        if (sourceNode == null || sourceNode.next == null) {
            return new LinkedListINode[]{sourceNode, null};
        }
        LinkedListINode fast = sourceNode.next;
        LinkedListINode slow = sourceNode;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        LinkedListINode[] headsOfSubList = new LinkedListINode[]{sourceNode, slow.next};
        slow.next = null;
        return headsOfSubList;
    }

    LinkedListINode merge(LinkedListINode head1, LinkedListINode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        LinkedListINode merged;
        if (head1.data <= head2.data) {
            merged = head1;
            merged.next = merge(head1.next, head2);
        } else {
            merged = head2;
            merged.next = merge(head1, head2.next);
        }
        return merged;
    }

}