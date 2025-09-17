package trees;

public interface Tree {
    boolean insert(int element);

    boolean constructTreeFromPreOrderInOrder(int[] sortedArray);

    boolean constructTreeFromLevelOrder(int[] array);

    boolean constructTreeFromPreorder(int[] preorder);

    boolean constructTreeFromPreOrderInOrder(int[] preorder, int[] inorder);

    boolean constructTreeFromInOrderPostOrder(int[] inorder, int[] postorder);

    boolean constructTreeFromPreOrderPostOrder(int[] preorder, int[] postorder);

    void print(TraversalOrder order);

    boolean delete(int element);

    int get(int element);

    int size();

    boolean contains(int element);

    int findMinimumElement();

    int findMaximumElement();

    int depth();

    int height();
}

class Node {
    private Node left;
    private Node right;
    private int element;

    Node(int element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    Node(Node left, Node right, int element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getElement() {
        return element;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setElement(int element) {
        this.element = element;
    }
}

enum TraversalOrder {
    PRE, IN, POST, LEVEL;
}
