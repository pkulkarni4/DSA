package linkedlist;

/*
Consider a singly linked list of integers that contains a loop. In other words, the tail of the linked list points to one of the previous nodes defining a loop or a circularity.

Write a snippet of code that detects the first node of the loop (that is, the node from which the loop starts).
 */
public class LinkedListCycleStartDetection {
    public static void main(String[] args) {
        LinkedListINode head = LinkedListINodeUtil.getLinkedListWithCycle();
        LinkedListCycleStartDetectionSolution ss = new LinkedListCycleStartDetectionSolution();
        boolean hasCycle = ss.doesLinkedListHaveCycle(head);
        System.out.println(hasCycle);
        System.out.println(ss.doesLinkedListHaveCycle(LinkedListINodeUtil.get5LinkedListINode()));
        System.out.println("----");
        LinkedListINode loop = ss.detectCycle(head);
        System.out.println(loop.data);
    }
}

class LinkedListCycleStartDetectionSolution {

    /*
    User two pointers- one slow and another fast.
    if slow meets faster pointer, then there is a cycle.
     */
    public boolean doesLinkedListHaveCycle(LinkedListINode head) {

        LinkedListINode slow = head;
        LinkedListINode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /*
    same as above but find where the loop starts
     */
    public LinkedListINode detectCycle(LinkedListINode head) {
        LinkedListINode slow = head;
        LinkedListINode fast = head;

        LinkedListINode loopDetectedNode = null;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("meeting point" + slow);
                break;
            }
        }
        if (fast == null || fast.next == null) {
            System.out.println("no loop");
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Loop detected at node:" + fast);
        return fast;
    }
}