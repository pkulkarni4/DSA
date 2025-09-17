package trees;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
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

    /*
    Creates bst using preorder and inorder traversal
    The idea is to construct the tree using pre-order traversal. Take the first element of the pre-order array and create root node.
    Find the index of this node in the in-order array. Create the left subtree using the elements present on left side of root node in in-order array.
    Similarly create the right subtree using the elements present on the right side of the root node in in-order array.

     */
    @Override
    public boolean constructTreeFromPreOrderInOrder(int[] preorder, int[] inorder) {
        int[] preIndex = {0};
        int start = 0, len = preorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        root = constructTreeFromPreOrderInOrder(preorder, preIndex, map, start, len);
        size = inorder.length;
        return false;
    }

    private Node constructTreeFromPreOrderInOrder(int[] preorder, int[] preIndex, Map<Integer, Integer> map, int start, int end) {
        if (start > end) return null;
        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;

        Node root = new Node(rootVal);

        // now, find where root lies in inorder
        int rootIdx = map.get(rootVal);

        root.setLeft(constructTreeFromPreOrderInOrder(preorder, preIndex, map, start, rootIdx - 1));
        root.setRight(constructTreeFromPreOrderInOrder(preorder, preIndex, map, rootIdx + 1, end));

        return root;
    }

    @Override
    public boolean constructTreeFromPreOrderPostOrder(int[] preorder, int[] postorder) {
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(postorder[i], i);
        }
        root = constructFromPrePost(preorder, postorder, map, 0, len - 1, 0);
        size = len;
        return true;
    }

    private Node constructFromPrePost(int[] preorder, int[] postorder, Map<Integer, Integer> map, int preStart, int preEnd, int postStart) {

        if (preStart > preEnd) return null;
        Node root = new Node(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftVal = preorder[preStart + 1];
        int mid = map.get(leftVal);
        int leftSize = mid - postStart + 1;

        root.setLeft(constructFromPrePost(preorder, postorder, map, preStart + 1, preStart + leftSize, postStart));
        root.setRight(constructFromPrePost(preorder, postorder, map, preStart + leftSize + 1, preEnd, postStart + leftSize));

        return root;
    }

    /*
        Creates bst using postorder and inorder traversal. Similar to above method - find root element from postorder which is last element.
         */
    @Override
    public boolean constructTreeFromInOrderPostOrder(int[] inorder, int[] postorder) {

        int start = 0, len = postorder.length - 1;
        int[] preIndex = {len};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        root = createTree(postorder, preIndex, map, start, len + 1);
        size = inorder.length;
        return false;
    }

    private Node createTree(int[] postorder, int[] preIndex, Map<Integer, Integer> map, int start, int end) {
        if (start > end) return null;
        if (preIndex[0] < 0) return null;

        int rootVal = postorder[preIndex[0]];
        preIndex[0]--;

        Node root = new Node(rootVal);

        if (start == end) return root;

        // now, find where root lies in inorder
        Integer rootIdx = map.get(rootVal);
        if (rootIdx != null) {
            root.setRight(createTree(postorder, preIndex, map, rootIdx + 1, end));
            root.setLeft(createTree(postorder, preIndex, map, start, rootIdx - 1));
        }
        return root;
    }

    /*
        creates bst based on a sorted array.
         */
    @Override
    public boolean constructTreeFromPreOrderInOrder(int[] nums) {
        if (nums == null) return false;
        int len = nums.length;
        if (len <= 0) return false;

        root = BSTCreateHelper(nums, 0, len - 1);

        return true;
    }

    private Node BSTCreateHelper(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        Node root = new Node(nums[mid]);
        size++;
        root.setLeft(BSTCreateHelper(nums, low, mid - 1));
        root.setRight(BSTCreateHelper(nums, mid + 1, high));
        return root;
    }

    @Override
    public boolean constructTreeFromLevelOrder(int[] arr) {
        int len = arr.length;
        root = insertLevelOrder(arr, len, 0);
        return true;
    }

    private Node insertLevelOrder(int[] arr, int len, int i) {
        Node root = null;
        if (i < len && arr[i] != -1) {
            root = new Node(arr[i]);
            size++;
            root.setLeft(insertLevelOrder(arr, len, 2 * i + 1));
            root.setRight(insertLevelOrder(arr, len, 2 * i + 2));
        }
        return root;
    }

    /*
    given array in preorder traversal of bst. construct a bst.
    in preorder, first element is the root, then we keep going left and then right.
    For example, preorder = [10,5,1,7,40,50]
    10 is root, {5,1,7} will be left nodes as they are smaller and {40,50} will be right nodes
     */
    @Override
    public boolean constructTreeFromPreorder(int[] preorder) {
        int length = preorder.length;
        root = insertPreOrder(preorder, 0, length - 1);
        size = length;
        return true;
    }

    private Node insertPreOrder(int[] preorder, int start, int end) {
        if (start > end) return null;
        Node n = new Node(preorder[start]);
        if (start == end) return n;
        // find first element greater than root to divide the array
        int start_idx = start + 1;
        int end_idx = end + 1;

        while (start_idx < end_idx) {
            int mid = (start_idx + end_idx) / 2;
            if (preorder[mid] > preorder[start]) {
                end_idx = mid;
            } else {
                start_idx = mid + 1;
            }
        }

        n.setLeft(insertPreOrder(preorder, start + 1, end_idx - 1));
        n.setRight(insertPreOrder(preorder, start_idx, end));
        return n;
    }

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
        if (curr == null) return 0;
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
        if (current == null) return -1;

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
