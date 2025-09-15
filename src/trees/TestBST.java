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
        tree1.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("\nsize: " + tree1.size());
        System.out.print(" LEVEL ORDER : ");
        tree1.print(TraversalOrder.LEVEL);
    }
}
