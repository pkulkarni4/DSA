package trees;

import java.util.*;

/*
LC: 297 - serialize and deserialize binary tree.
ex: Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
 */
public class Codec {
    int index = 0;

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    void dfs(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append(root).append(",");
            return;
        }
        res.append(root.element).append(",");
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        String[] split = data.split(",");
        nodes.addAll(Arrays.asList(split));
        return deserialize(nodes, split.length);
    }

    TreeNode deserialize(Deque<String> data, int len) {
        String val = data.remove();
        if (val.equals("null") || val.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize(data, len);
        node.right = deserialize(data, len);
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, null, 4, 5};


        // Your Codec object will be instantiated and called as such:
        Codec ser = new Codec();
        TreeNode root = ser.constructTree(arr);
        Codec deser = new Codec();
        String str = deser.serialize(root);
        TreeNode n = deser.deserialize(str);
        //TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println("serialized: "+str);
        printTreeNode(n);
    }

    static void printTreeNode(TreeNode node) {
        if (node != null) {
            System.out.print(node.element + " ");
            printTreeNode(node.left);
            printTreeNode(node.right);
        }
    }

    TreeNode constructTree(Integer[] arr) {
        return constructTree(arr, arr.length, 0);
    }

    TreeNode constructTree(Integer[] arr, int len, int index) {
        TreeNode node = null;
        if (index < len) {
            node = new TreeNode(arr[index]);
            node.left = constructTree(arr, len, 2 * index + 1);
            node.right = constructTree(arr, len, 2 * index + 2);
        }
        return node;
    }
}
