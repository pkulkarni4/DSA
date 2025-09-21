package trees;

/*
LC: 100
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value

ex:
input, p = [1,2,3], q=[1,2,3]
output: true

input, p=[1,2], q=[1, null, 2]
 output: false
 */

public class SameTree {
    public static void main(String[] args) {
        SameTree100Solution s = new SameTree100Solution();

        Integer[] p1 = {1, 2};
        Integer[] q1 = {1, null, 2};
        TreeNode pTreeNode1 = s.constructTree(p1);
        TreeNode qTreeNode1 = s.constructTree(q1);
        // print trees
        printTree(pTreeNode1);
        System.out.println();
        printTree(qTreeNode1);
        System.out.println();
        boolean res = s.isSameTree(pTreeNode1, qTreeNode1);
        System.out.println(res);

        Integer[] p2 = {1, 2, 3};
        Integer[] q2 = {1, 2, 3};
        TreeNode pTreeNode2 = s.constructTree(p2);
        TreeNode qTreeNode2 = s.constructTree(q2);
        // print trees
        printTree(pTreeNode2);
        System.out.println();
        printTree(qTreeNode2);
        System.out.println();
        res = s.isSameTree(pTreeNode2, qTreeNode2);
        System.out.println(res);
    }

    static void printTree(TreeNode node) {
        if (node != null) {
            System.out.print(node.element + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }
}

class SameTree100Solution {
    public TreeNode constructTree(Integer[] arr) {
        int len = arr.length;
        TreeNode root = constructTree(arr, len, 0);
        return root;
    }

    private TreeNode constructTree(Integer[] arr, int len, int index) {
        TreeNode node = null;
        if (index < len) {
            node = new TreeNode(arr[index]);
            node.left = constructTree(arr, len, 2 * index + 1);
            node.right = constructTree(arr, len, 2 * index + 2);
        }
        return node;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null && p.element != q.element) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}