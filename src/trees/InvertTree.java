package trees;

/*
LC: 226 - Invert a binary tree.
Given a root of a binary tree, invert and return its root.

Ex: root = [4,2,7,1,3,6,9]
return: [4, 7, 2, 9,6,3,1]
 */
public class InvertTree {
    public static void main(String[] args) {
        InvertTree226Solution s = new InvertTree226Solution();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        // TreeNode inverted1 = s.invertTree(root);
        // printTree(inverted1);
        //
        int[] input1 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root1 = s.constructTree(input1);
        printTree(root1);
        System.out.println();
        TreeNode inverted2 = s.invertTree(root1);
        printTree(inverted2);
        System.out.println();
        TreeNode invertInverted1 = s.invertTree(inverted2);
        printTree(invertInverted1);
    }

    static void printTree(TreeNode node) {
        if (node != null) {
            System.out.print(node.element + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }
}

class InvertTree226Solution {

    public TreeNode constructTree(int[] arr) {
        int len = arr.length;
        TreeNode root = constructTree(arr, len, 0);
        return root;
    }

    TreeNode constructTree(int[] arr, int len, int index) {
        TreeNode node = null;
        if (index < len) {
            node = new TreeNode(arr[index]);
            node.left = constructTree(arr, len, 2 * index + 1);
            node.right = constructTree(arr, len, 2 * index + 2);
        }
        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;


        return root;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */