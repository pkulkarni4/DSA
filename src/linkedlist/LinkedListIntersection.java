package linkedlist;

/*
Consider two singly linked lists. Write a snippet of code that checks whether the two lists intersect.
The intersection is based on reference, not on value, but you should return the value of the intersection node.
So, check the intersection by reference and return the value.
 */
public class LinkedListIntersection {
    public static void main(String[] args) {
        // 1->2->3->4->5->null
        LinkedListINode l1 = LinkedListINodeUtil.get5LinkedListINode();
        // 1->2->3->null
        LinkedListINode l2 = LinkedListINodeUtil.get3LinkedListINode();
        // 1->2->3->2->1->null
        LinkedListINode commonList = LinkedListINodeUtil.getOddPalindromeLinkedList();

        // connect l2 -> commonlist , 1->2->3-> 1->2->3->2->1->null
        l2.next.next.next = commonList;

        // connect l1 -> commonList, 1->2->3->4->5-> 1->2->3->2->1->null
        l1.next.next.next.next = commonList;

        LinkedListIntersectionSolution ss = new LinkedListIntersectionSolution();
        int intersectionVal = ss.findIntersectionNode(l1, l2);
        System.out.println(intersectionVal);
    }
}
class LinkedListIntersectionSolution {
    /*
    Find shortest linkedlist among l1 and l2.
    start at the same length, check if l1Node.next == l2Node.next, if so, return value.
     */
    public int findIntersectionNode(LinkedListINode l1, LinkedListINode l2) {
        int lenL1 = findLen(l1);
        int lenL2 = findLen(l2);

        if(lenL1> lenL2) {
            int k = lenL1-lenL2;
            for(int i=0;i<k;i++){
                l1 = l1.next;
            }
        } else {
            int k = lenL2-lenL1;
            for(int i=0;i<k;i++){
                l2 = l2.next;
            }
        }

        LinkedListINode s1 = l1;
        LinkedListINode s2 = l2;
        while(s1 !=null && s2 != null) {
            if(s1 == s2){
                return s1.data;
            }
            s1 = s1.next;
            s2 = s2.next;
        }

        return -1;
    }

    int findLen(LinkedListINode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}