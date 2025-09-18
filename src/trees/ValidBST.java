package trees;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        ValidBSTSolution s = new ValidBSTSolution();
        System.out.println(s.isBinarySearchTree(root));
    }
}

class TreeNode {
    Integer element;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer element) {
        this.element = element;
    }

    public TreeNode(Integer element, TreeNode left, TreeNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}

class ValidBSTSolution {
    public boolean isBinarySearchTree(TreeNode root) {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((max != null && root.element >= max) || (min != null && root.element <= min)) return false;
        return isBinarySearchTree(root.left, min, root.element) && isBinarySearchTree(root.right, root.element, max);
    }
}
