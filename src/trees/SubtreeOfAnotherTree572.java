package trees;

/*
Given the roots of two binary trees, root and subRoot, return true if there is a subtree of root with same structure and node values of subRoot and false otherwise.
Tree is also a subtree of itself.

Example:
Input, root: [3,4,5,1,2], subRoot: [4,1,2]
output: true
Input, root: [3,4,5,1,2, null, null, null, null, 0], subRoot: [4,1,2]
output: false
 */
public class SubtreeOfAnotherTree572 {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(1);
        Node n5 = new Node(2);
        n1.setLeft(n2);
        n2.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);

        Node s1 = new Node(4);
        Node s2 = new Node(1);
        Node s3 = new Node(2);
        s1.setLeft(s2);
        s1.setRight(s3);

        BinarySearchTree t1 = new BinarySearchTree();
        t1.insertLevelOrder(new int[]{3,4,5,1,2});
        BinarySearchTree t2 = new BinarySearchTree();
        t2.insertLevelOrder(new int[] {4,1,2});

        BinarySearchTree t3 = new BinarySearchTree();
        t3.insertLevelOrder(new int[]{3,4,5,1,2, -1, -1, -1, -1, 0}); // -1 acts as null, means skip those nodes
        BinarySearchTree t4 = new BinarySearchTree();
        t4.insertLevelOrder(new int[] {4,1,2});

        Solution572 s = new Solution572();
        boolean retVal = s.isSubtree(n1, s1);
        System.out.println(retVal);
        boolean retVal1 = s.isSubtree(t1.root, t2.root);
        System.out.println(retVal1);
        boolean retVal3 = s.isSubtree(t3.root, t4.root);
        System.out.println(retVal3);

    }
}

class Solution572 {
    public boolean isSubtree(Node root, Node subRoot) {
        if(root == null) return false;
        if(!match(root, subRoot)){
            return (isSubtree(root.getLeft(), subRoot) || isSubtree(root.getRight(), subRoot));
        }
        return true;
    }

    private boolean match(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return (p.getElement() == q.getElement()
                && match(p.getLeft(), q.getLeft())
                && match(p.getRight(), q.getRight())
                );
    }
}