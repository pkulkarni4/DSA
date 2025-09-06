package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedListINode head = LinkedListINodeUtil.getSortedLinkedListINodesWithDuplicates();

        //RemoveAllRepeatingNumbersSolution ss= new RemoveAllRepeatingNumbersSolution();
        //head = ss.removeElements(head, 6);

        SolutionRemoveDuplicates s = new SolutionRemoveDuplicates();
        //s.UsingMap(head);
        s.usingTwoPointers(head);
        // print
        LinkedListINodeUtil.printLinkedListINode(head);
    }
}

class SolutionRemoveDuplicates {
    // time complexity: O(n)
    // space complexity: O(n)
    public void UsingMap(LinkedListINode node) {
        Set<Integer> set = new HashSet<>();
        LinkedListINode current = node;
        LinkedListINode prev = null;
        while (current != null) {
            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    public void usingTwoPointers(LinkedListINode head) {
        LinkedListINode curr = head;
        while(curr != null){
            LinkedListINode runner = curr;
            while(runner.next != null){
                if(runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else{
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }
}

class RemoveAllRepeatingNumbersSolution {
    public LinkedListINode removeElements(LinkedListINode head, int val) {
        while(head != null && head.data == val) {
            head = head.next;
        }

        LinkedListINode curr = head;
        while(curr!=null && curr.next!=null) {
            if(curr.next.data == val) {
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }
        return head;
    }
}