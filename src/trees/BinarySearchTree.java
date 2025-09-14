package trees;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Sample implementation for BST for integers.
search, insertion, and deletion can be performed in O(log n)

depth: of a node is number of edges from the node to the tree's root. Root will have depth of 0.
height: of a node is number of edges on the longest path from the node to a leaf. Leaf will have height of 0. height of tree is height of root.

 */
public class BinarySearchTree implements Tree {

    Node root;
    int size;

    @Override
    public boolean insert(int element) {
        if (root == null) {
            root = new Node(element);
            size++;
            return true;
        }
        if (root.getElement() == element) {
            // do nothing
            return true;
        }

        insert(root, element);

        size++;

        return true;
    }

    Node insert(Node node, int element) {
        if (node == null) {
            return new Node(element);
        }
        if (element < node.getElement()) {
            node.setLeft(insert(node.getLeft(), element));
        } else {
            node.setRight(insert(node.getRight(), element));
        }
        return node;
    }

    @Override
    public int depth() {
        return depth(root);
    }

    private int depth(Node curr) {
        if(curr == null) return 0;
        return 0;
    }

    /*
    max of height of right and left subtree + 1
     */
    @Override
    public int height() {
        return height(root);
    }

    private int height(Node current) {
        if(current == null) return -1;

        int leftHeight = height(current.getLeft());
        int rightHeight = height(current.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public boolean contains(int element) {
        return contains(root, element);
    }

    boolean contains(Node current, int element) {
        if (current == null) return false;
        if (current.getElement() == element) return true;
        return current.getElement() < element ? contains(current.getRight(), element) : contains(current.getLeft(), element);
    }

    @Override
    public void print(TraversalOrder order) {
        if (size() == 0) {
            System.out.println("empty");
            return;
        }

        switch (order) {
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
            case LEVEL:
                printLevelOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    protected void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.getLeft());
        System.out.print(" " + node.getElement());
        printInOrder(node.getRight());
    }

    protected void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(" " + node.getElement());
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    protected void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print(" " + node.getElement());
    }

    void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(" " + curr.getElement());
            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
    }

    @Override
    public boolean delete(int element) {
        if (contains(element)) {
            root = delete(root, element);
            size--;
            return true;
        }
        return false;
    }

    /*
    Once the element is found, we have following cases:
    case 1: no children
    case 2: 1 child
    case 3: 2 children
     */
    private Node delete(Node current, int element) {
        if (current == null) return null;
        if (element < current.getElement()) {
            current.setLeft(delete(current.getLeft(), element));
        } else if (element > current.getElement()) {
            current.setRight(delete(current.getRight(), element));
        } else {
            // case1 : no child
            if (current.getLeft() == null && current.getRight() == null) {
                current = null;
            } else if (current.getLeft() == null) {
                current = current.getRight();
            } else if (current.getRight() == null) {
                current = current.getLeft();
            } else {
                // case 3: 2 children
                Node minNodeFromRightSubtree = findMin(current.getRight());
                current.setElement(minNodeFromRightSubtree.getElement());
                current.setRight(delete(current.getRight(), minNodeFromRightSubtree.getElement()));
            }
        }
        return current;
    }

    @Override
    public int findMaximumElement() {
        Node temp = findMax(root);
        return temp.getElement();
    }

    @Override
    public int findMinimumElement() {
        Node curr = findMin(root);
        return curr.getElement();
    }

    private Node findMin(Node current) {
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private Node findMax(Node current) {
        while (current != null && current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    @Override
    public int get(int element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }
}
