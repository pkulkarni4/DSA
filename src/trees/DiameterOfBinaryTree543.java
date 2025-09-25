package trees;

/*
LC#543: diameter of a binary tree.
len of longest path between any nodes in a tree
Ex: root = [1,2,3,4,5]
output: 3 , distance between nodes 4 and 3 is 3. [4, 2, 1, 3]
 */
public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {

        int[][] examples = {
                {1, 2, 3, 4, 5},
                {1, 2}
        };
        for (int i = 0; i < examples.length; i++) {
            DiameterOfBinaryTree543Solution s = new DiameterOfBinaryTree543Solution();
            TreeNode root = constructTree(examples[i]);
            int maxPath = s.diameterOfBinaryTree(root);
            System.out.println("max path: " + maxPath);
        }
    }

    private static TreeNode constructTree(int[] example) {
        int len = example.length;
        return constructTree(example, len, 0);
    }

    static TreeNode constructTree(int[] example, int len, int index) {
        TreeNode node = null;
        if (index < len) {
            node = new TreeNode(example[index]);
            node.left = constructTree(example, len, 2 * index + 1);
            node.right = constructTree(example, len, 2 * index + 2);
        }
        return node;
    }
}

class DiameterOfBinaryTree543Solution {
    /*
        max path from source to dest
         */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = {0};
        dfs(root, res);
        return res[0];
    }

    int dfs(TreeNode curr, int[] res) {
        if (curr == null) return 0;
        int left = dfs(curr.left, res);
        int right = dfs(curr.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }
}