package linkedlist;

public class LinkedListINode {
    int data;
    LinkedListINode next;

    public LinkedListINode(int data) {
        this.data = data;
    }

    public LinkedListINode() {
    }

    @Override
    public String toString() {
        return "LinkedListINode {" +
                " data = " + data + " } ";

    }
}