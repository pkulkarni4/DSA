package linkedlist;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DblLinkedList ll = new DblLinkedList();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertAtEnd(3);
        ll.print();
        System.out.println(ll.size());
        ll.delete(2);
        // ll.deleteByIndex(1);
        ll.printReverse();
        System.out.println(ll.size());
    }
}

class DblLinkedList implements LinkedListInt {
    private DblLinkedListINode head;
    private DblLinkedListINode tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertFirst(int n) {
        DblLinkedListINode node = new DblLinkedListINode(n);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }

        size++;
    }

    @Override
    public void insertAtEnd(int n) {
        DblLinkedListINode node = new DblLinkedListINode(n);
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;

        if (head == null) {
            head = node;
        }

        size++;
    }

    @Override
    public void print() {
        DblLinkedListINode current = head;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    public void printReverse() {
        DblLinkedListINode current = tail;
        while (current != null) {
            System.out.print(current);
            current = current.prev;
        }
        System.out.println();
    }

    @Override
    public boolean delete(int n) {
        DblLinkedListINode current = head;
        DblLinkedListINode prev = null;
        while (current != null && current.data != n) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        DblLinkedListINode current = head;
        DblLinkedListINode prev = null;
        int pointer = 0;
        while (current != null && pointer != index) {
            prev = current;
            current = current.next;
            pointer++;
        }

        if (current != null) {
            prev.next = current.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
            return true;
        }

        return false;
    }

}

class DblLinkedListINode {
    int data;
    DblLinkedListINode next;
    DblLinkedListINode prev;

    public DblLinkedListINode(int data) {
        this.data = data;
    }

    public DblLinkedListINode() {
    }

    @Override
    public String toString() {
        return "DblLinkedListINode {" +
                " data = " + data +
                " } ";
    }
}