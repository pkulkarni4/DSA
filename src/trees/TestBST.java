package trees;

public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(40);
        tree.insert(30);
        tree.insert(45);
        tree.insert(15);
        tree.insert(33);
        tree.insert(42);
        tree.insert(56);
        tree.insert(5);
        tree.insert(17);
        tree.insert(41);
        tree.insert(67);

        System.out.println("size : " + tree.size());

        System.out.println("height of the tree: " + tree.height());

        System.out.println("min element: " + tree.findMinimumElement());
        System.out.println("max element: " + tree.findMaximumElement());

        System.out.println("contains: 15 ? " + tree.contains(15));
        System.out.println("containas 100? " + tree.contains(100));

        System.out.print(" PRE ORDER : ");
        tree.print(TraversalOrder.PRE);
        System.out.println();
        System.out.print(" IN ORDER : ");
        tree.print(TraversalOrder.IN);
        System.out.println();
        System.out.print(" POST ORDER : ");
        tree.print(TraversalOrder.POST);
        System.out.println();
        System.out.print(" LEVEL ORDER : ");
        tree.print(TraversalOrder.LEVEL);

        System.out.println("\nremove 30 : " + tree.delete(30));
        System.out.println("size: " + tree.size());
        System.out.print(" LEVEL ORDER : ");
        tree.print(TraversalOrder.LEVEL);

        ///  create bst with sorted array
        Tree tree1 = new BinarySearchTree();
        tree1.constructTreeFromPreOrderInOrder(new int[]{1, 2, 3});
        System.out.println("\nsize: " + tree1.size());
        System.out.print(" PRE ORDER : ");
        tree1.print(TraversalOrder.PRE);
        System.out.print(" POST ORDER : ");
        tree1.print(TraversalOrder.POST);

        // create using preorder
        Tree treePreorder = new BinarySearchTree();
        treePreorder.constructTreeFromPreorder(new int[]{10, 5, 1, 7, 40, 50});
        System.out.println("\nsize: " + treePreorder.size());
        System.out.print(" IN ORDER : ");
        treePreorder.print(TraversalOrder.IN);

        // create using inorder and preorder
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        Tree tree3 = new BinarySearchTree();
        tree3.constructTreeFromPreOrderInOrder(preorder, inorder);
        System.out.println("\n tree 3 size " + tree3.size());
        System.out.println(" PRE ORDER ");
        tree3.print(TraversalOrder.PRE);

        int[] inorder1 = {2, 1};//{4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {2, 1};// {8, 4, 5, 2, 6, 7, 3, 1};
        Tree tree4 = new BinarySearchTree();
        tree4.constructTreeFromInOrderPostOrder(inorder1, postorder);
        System.out.println("\n tree 4 size " + tree4.size());
        System.out.println(" PRE ORDER ");
        tree4.print(TraversalOrder.PRE);

        int[] preorder5 = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder5 = {4, 5, 2, 6, 7, 3, 1};
        Tree tree5 = new BinarySearchTree();
        tree5.constructTreeFromPreOrderPostOrder(preorder5, postorder5);
        System.out.println("\n tree 5 size " + tree5.size());
        System.out.println(" PRE ORDER ");
        tree5.print(TraversalOrder.PRE);

    }
}
