package others;

import java.util.ArrayList;
import java.util.List;

public class TestBacktracking {
    public static void main(String[] args) {
        Tree[] trees = {new Tree("Apple"), new Tree("Mango"), new Tree("Orange")};
        int len = trees.length;
        List<List<Tree>> combo = new ArrayList<>();
        List<Tree> current = new ArrayList<>();
        printTrees(trees, current, combo, len, 0);
      //  printCombination(combo);
        //reset
        combo = new ArrayList<>();
        current = new ArrayList<>();

        plantTrees(trees, current, combo, len, 0);
        printCombination(combo);
    }

    static void printCombination(List<List<Tree>> combo) {
        for (List<Tree> list : combo) {
            for (Tree str : list) {
                System.out.print(str.getName() + " ");
            }
            System.out.println();
        }
    }

    static void printTrees(Tree[] trees, List<Tree> current, List<List<Tree>> combo, int len, int index) {
        if (current.size() == len) {
            combo.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < trees.length; i++) {
            //  System.out.println(" trees["+i+"]: " + trees[i] + " trees["+index+"]: " + trees[index]);
            if (canTreeBePlantedNextTo(current, trees[i])) {
                // continue;

                current.add(trees[i]);
                // System.out.println("Allowing: last tree planted: " + current.getLast().getName() + "   tree[" + i + "] : " + trees[i].getName());

                printTrees(trees, current, combo, len, index + 1);
                current.removeLast();
            }
            ///printTrees(trees, current, combo, len, index);
        }
    }

    static void plantTrees(Tree[] trees, List<Tree> current, List<List<Tree>> combo, int len, int index) {
        if (current.size() == len) {
            combo.add(new ArrayList<>(current));
            return;
        }

        if (canTreeBePlantedNextTo(current, trees[index])) {
            current.add(trees[index]);
            printTrees(trees, current, combo, len, index + 1);
            current.removeLast();
            printTrees(trees, current, combo, len, index + 1);
        }

    }

    static boolean canTreeBePlantedNextTo(List<Tree> current, Tree tree) {
        if (current.isEmpty()) {
            return true;
        }
        Tree lastTreePlanted = current.getLast();

        if ((lastTreePlanted.getName().equals(tree.getName()) || current.contains(tree) || ("Orange".equals(lastTreePlanted.getName()) && "Apple".equals(tree.getName())) || ("Apple".equals(lastTreePlanted.getName()) && "Orange".equals(tree.getName())))) {
            //System.out.println("Not allowing: last tree planted: " + lastTreePlanted.getName() +"   tree: " + tree.getName());
            return false;
        }
        // System.out.println("Allowing : last tree planted: " + lastTreePlanted.getName() +"   tree: " + tree.getName());
        return true;
    }
}

class Tree {
    private String name;

    public Tree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object o) {
        if (o instanceof Tree) {
            return this.name.equals(((Tree) o).name);
        }
        return false;
    }
}