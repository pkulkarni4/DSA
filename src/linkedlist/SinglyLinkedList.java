package linkedlist;

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertFirst(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
       // ll.print();
        System.out.println(ll.size());
       // ll.deleteByIndex(1);
       // ll.delete(3);
        //ll.print();
        System.out.println(ll.size());

        ll.rearrange((3));
        ll.print();
    }
}

interface LinkedListInt {
    void insertFirst(int n);

    void insertAtEnd(int n);

    void print();

    void printReverse();

    boolean delete(int n);

    boolean deleteByIndex(int index);

    boolean isEmpty();

    int size();
}

class LinkedList implements LinkedListInt {

    private LinkedListINode head;
    private LinkedListINode tail;
    private int size = 0;

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
        LinkedListINode node = new LinkedListINode(n);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }
        size++;
    }

    @Override
    public void insertAtEnd(int n) {
        LinkedListINode node = new LinkedListINode(n);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;

        if (head == null) {
            head = node;
        }
        size++;
    }

    @Override
    public void print() {
        LinkedListINode current = head;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public void printReverse() {
        // do a recursive call and print.
    }

    @Override
    public boolean delete(int n) {
        LinkedListINode current = head;
        LinkedListINode prev = null;
        if (current != null && current.data == n) {
            head = current.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
        while (current != null && current.data != n) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            // data found
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
        LinkedListINode current = head;
        LinkedListINode prev = null;
        int pointer = 0;
        while (current != null && pointer != index) {
            prev = current;
            current = current.next;
            pointer++;
        }

        if (current != null) {
            // data found
            prev.next = current.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
            return true;
        }
        return false;
    }

    public void rearrange(int n) {
        LinkedListINode curr = head;
        head = curr;
        tail = curr;

        while(curr != null) {
            LinkedListINode nextNode = curr.next;
            if(curr.data < n) {
                curr.next = head;
                head = curr;
            } else {
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        tail.next = null;
    }
}

