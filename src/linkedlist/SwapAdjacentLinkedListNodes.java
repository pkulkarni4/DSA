package linkedlist;

/*
Consider a singly linked list. Write a snippet of code that swaps the adjacent nodes so that a list such as 1 → 2 → 3 → 4 → null becomes 2 → 1 → 4 → 3 → null.
Consider swapping the adjacent nodes, not their values!
*/
public class SwapAdjacentLinkedListNodes {
    public static void main(String[] args) {
        LinkedListINode head = LinkedListINodeUtil.get5LinkedListINode();
        LinkedListINodeUtil.printLinkedListINode(head);

        SwapAdjacentNodes ss = new SwapAdjacentNodes();
        LinkedListINode swapped = ss.swapPairs(head);
        LinkedListINode swappedIter =ss.swapAdjacent(head);
        LinkedListINodeUtil.printLinkedListINode(swapped);
        LinkedListINodeUtil.printLinkedListINode(swappedIter);

        LinkedListINode fourNod = LinkedListINodeUtil.getEvenPalindromeLinkedList();
        LinkedListINodeUtil.printLinkedListINode(fourNod);
        LinkedListINode fourNodSwapped = ss.swapPairs(fourNod);
        LinkedListINodeUtil.printLinkedListINode(fourNodSwapped);
    }
}

class SwapAdjacentNodes {
    // recursive
    public LinkedListINode swapPairs(LinkedListINode head) {
        if(head == null || head.next == null) return head;

        LinkedListINode n=head.next;
        head.next = swapPairs(head.next.next);
        n.next=head;
        return n;
    }

    // iterative
    public LinkedListINode swapAdjacent(LinkedListINode head) {
        if(head == null || head.next == null) return head;
        LinkedListINode curr = head;
        LinkedListINode prev = null;

        while (curr != null && curr.next!=null) {
            LinkedListINode node1 = curr;
            LinkedListINode node2 = curr.next;
            LinkedListINode node3 = curr.next.next;
            LinkedListINode temp = node1;
            node1=node2;
            node3=temp;

            // links
            node1.next = node2;
            node2.next = node3;
            if(prev == null) {
                head = node1;
            } else {
                prev.next= node1;
            }
            prev = node2;
            curr = node3;
        }
        return head;
    }
}