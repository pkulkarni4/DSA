package linkedlist;

public class LinkedListNode<T> {

    Node<T> first;
    Node<T> last;

    LinkedListNode(){

    }


    void linkLast(T e){
        Node<T> l = last;
        Node<T> n = new Node<>(l, e, null);
    }

}
class Node<T> {
Node<T> next;
Node<T> prev;
T data;
Node(Node<T> prev, T data,Node<T> next) {
    this.data = data;
    this.next=next;
    this.prev = prev;
}
}
