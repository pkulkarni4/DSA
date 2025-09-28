package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static trees.InvertTree.printTree;

/*
LC #199: Binary Tree Right Side View
Given root of a binary tree, return the values of the nodes you can see ordered from top to bottom.

Examples:

root = [1,2,3,null, 5, null, 4]
output: [1,3,4]

root = [1,2,3,4,null,null,null,5]
output: [1,3,4,5]

 */
public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {

        Integer[][] examples = {
                {1, 2, 3, null, 5, null, 4},
                {1, 2, 3, 4, null, null, null, 5},
                {1, null, 3},
                {}
        };
        BinaryTreeRightSideView199Solution s = new BinaryTreeRightSideView199Solution();
        for (Integer[] tree : examples) {
            TreeNode root = s.constructTree(tree);
            //printTree(root);
            //System.out.println();
            List<Integer> res = s.rightSideView(root);
            for (Integer o : res) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }
}

class BinaryTreeRightSideView199Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                i++;
                TreeNode curr = queue.poll();
                if (curr != null) {
                    if (i == size) {
                        res.add(curr.element);
                    }
                    if(curr.left!=null) {
                        queue.add(curr.left);
                    }
                    if(curr.right!=null) {
                        queue.add(curr.right);
                    }
                }
            }
        }
        return res;
    }

    /*
    construct tree with level order
     */
    public TreeNode constructTree(Integer[] tree) {
        int len = tree.length;
        TreeNode root = constructTree(tree, len, 0);
        return root;
    }

    TreeNode constructTree(Integer[] tree, int len, int index) {
        TreeNode node = null;
        if (index < len) {
            node = new TreeNode(tree[index]);
            node.left = constructTree(tree, len, 2 * index + 1);
            node.right = constructTree(tree, len, 2 * index + 2);
        }
        return node;
    }
}