package linkedlist;

public class AddTwoSinglyLinkedListNumbers {
    public static void main(String[] args) {
        SingleLinkedList sll1 = new SingleLinkedList();
        sll1.insertFirst(1);
        sll1.insertFirst(2);
        sll1.insertFirst(3);
        sll1.insertFirst(4);
        sll1.insertFirst(5);

        SingleLinkedList sll2 = new SingleLinkedList();
        sll2.insertFirst(1);
        sll2.insertFirst(2);
        sll2.insertFirst(3);
        sll2.insertFirst(4);
        sll2.insertFirst(5);

        sll1.sum(sll2);
    }
}

class SingleLinkedList {

    private final class Node {

        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void sum(SingleLinkedList sll) {

        SingleLinkedList sllResult = new SingleLinkedList();

        //Node node = sum(head, sll.head, 0);
        Node node = addTwoNums(head, sll.head, 0);

        sllResult.head = node;

        sllResult.reverseLinkedList(sllResult.head);

        sllResult.print();
    }

    Node addTwoNums(Node p, Node q, int carry) {
        // base case
        if (p == null && q == null && carry == 0) return null;

        int pVal = p == null ? 0 : p.data;
        int qVal = q == null ? 0 : q.data;
        int sum = pVal + qVal + carry;
        Node sumNode = new Node();
        sumNode.data=sum % 10;

        sumNode.next = addTwoNums(p == null ? null : p.next, q == null ? null : q.next, sum >= 10 ? 1 : 0);
        return sumNode;
    }

    private Node sum(Node node1, Node node2, int carry) {

        if (node1 == null && node2 == null && carry == 0) {
            return null;
        }

        Node resultNode = new Node();
        int value = carry;

        if (node1 != null) {
            value += node1.data;
        }

        if (node2 != null) {
            value += node2.data;
        }

        resultNode.data = value % 10;

        if (node1 != null || node2 != null) {
            Node more = sum(node1 == null
                    ? null : node1.next, node2 == null
                    ? null : node2.next, value >= 10 ? 1 : 0);

            resultNode.next = more;
        }

        return resultNode;
    }

    private Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node remaining = reverseLinkedList(node.next);

        node.next.next = node;
        node.next = null;

        head = remaining;

        return remaining;
    }

    public void print() {

        System.out.println("\nResult:");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
