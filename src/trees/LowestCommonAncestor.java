package trees;

/*
LC: 235 Find lowest common ancestor
Given a bst, find LCA of two nodes.
Ex:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
output: 6

 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor235Solution s = new LowestCommonAncestor235Solution();
        Integer[] root1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = s.constructTree(root1);
        TreeNode p1 = findInTree(root, 7);
        TreeNode q1 = findInTree(root, 4);

        TreeNode res = s.lowestCommonAncestor(root, p1, q1);
        System.out.println("LCA --> " + res.element);
    }

    static TreeNode findInTree(TreeNode root, Integer target) {
        if (target.equals(root.element)) {
            return root;
        } else if (target < root.element) {
            return findInTree(root.left, target);
        } else {
            return findInTree(root.right, target);
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestor235Solution {
    /*
    if p.val and q.val less than root.val, then LCA lies on left with root.val as max,
    otherwise LCA lies on right with root as min and int_max as max.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.element < root.element && q.element < root.element) {
                root = root.left;
            } else if (p.element > root.element && q.element > root.element) {
                root = root.right;
            } else {
                break;
               // return root;
            }
        }
        return root;
    }

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

}