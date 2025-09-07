package linkedlist;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

ex:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
 */
public class MergeKSortedLists23 {
    public static void main(String[] args) {
        LinkedListINode[] lists = new LinkedListINode[]{LinkedListINodeUtil.getSortedLinkedListINodesWithDuplicates(), LinkedListINodeUtil.getSortedLinkedListINodesWithDuplicates()};
        MergeKSortedListsSolution ss = new MergeKSortedListsSolution();
        LinkedListINode head = ss.mergeKListsBruteForce(lists);
        LinkedListINodeUtil.printLinkedListINode(head);

        LinkedListINode[] lists1 = new LinkedListINode[]{LinkedListINodeUtil.getSortedLinkedListINodesWithDuplicates(), LinkedListINodeUtil.get3LinkedListINode(), LinkedListINodeUtil.getSortedLinkedListINodesWithDuplicates()};
        LinkedListINode head1 = ss.mergeKLists(lists1);
        LinkedListINodeUtil.printLinkedListINode(head1);

        LinkedListINode[] lists2 = new LinkedListINode[]{LinkedListINodeUtil.getSorted3LinkedList(), LinkedListINodeUtil.getSorted4LinkedList()};
        LinkedListINode head2 = ss.mergeKLists(lists2);
        LinkedListINodeUtil.printLinkedListINode(head2);
    }
}

class MergeKSortedListsSolution {
    /*
    Use divide and conquer method - divide the list into halves and merge
    Time complexity O(n log k)
     */
    public LinkedListINode mergeKLists(LinkedListINode[] lists) {
        if (lists == null) return null;
        int length = lists.length;
        if (length == 0) return null;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i + interval < length; ) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                i = i + interval * 2;
            }
            interval = interval * 2;
        }
        return lists[0];
    }

    /*
    Time complexity O(n*k)
     */

    public LinkedListINode mergeKListsBruteForce(LinkedListINode[] lists) {
        if (lists == null) return null;
        int length = lists.length;
        if (length == 0) return null;

        LinkedListINode head = new LinkedListINode(0);
        LinkedListINode temp = head;
        while (true) {
            int p = 0;
            for (int i = 0; i < length; i++) {
                if (lists[p] == null || (lists[i] != null && lists[p].data > lists[i].data)) {
                    p = i;
                }
            }
            if (lists[p] == null) {
                break;
            }
            temp.next = lists[p];
            temp = temp.next;
            lists[p] = lists[p].next;
        }
        return head.next;
    }

    /*
    merge two sorted linked lists
     */
    LinkedListINode mergeTwoLists(LinkedListINode left, LinkedListINode right) {
        if (left == null) return right;
        if (right == null) return left;

        LinkedListINode newNode = new LinkedListINode(-1);
        LinkedListINode res = newNode;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                newNode.next = new LinkedListINode(left.data);
                left = left.next;
            } else {
                newNode.next = new LinkedListINode(right.data);
                right = right.next;
            }
            newNode = newNode.next;
        }
        // leftovers in left side, if any
        if (left != null) {
            newNode.next = left;
        }

        // leftovers in right side, if any
        if (right != null) {
            newNode.next = right;
        }
        return res.next;
    }
}
