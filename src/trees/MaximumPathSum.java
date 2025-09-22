package trees;

public class MaximumPathSum {
    public static void main(String[] args) {
        MaximumPathSum124Solution s = new MaximumPathSum124Solution();
        Integer[] tree1 = {-10, 9, 20, null, null, 15, 7};
        TreeNode root1 = s.constructTree(tree1);
        int maxSum = s.maxPathSum(root1);
        System.out.println(maxSum);
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
class MaximumPathSum124Solution {
    public TreeNode constructTree(Integer[] arr) {
        int len = arr.length;
        return constructTree(arr, len, 0);
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

    /*

     */
    public int maxPathSum(TreeNode root) {
        int[] res = {root.element};
        // Compute maximum path sum and store it in 'res'
        maxPathSumUtil(root, res);
        return res[0];
    }

    int maxPathSumUtil(TreeNode root, int[] res) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSumUtil(root.left, res));
        int right = Math.max(0, maxPathSumUtil(root.right, res));

        int rootElem = root.element == null ? 0 : root.element;
        res[0] = Math.max(res[0], left + right + rootElem);

        return rootElem + Math.max(left, right);
    }
}