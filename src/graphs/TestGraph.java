package graphs;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        Graph<String> g = new UndirectedGraph<>();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("D", "E");
        // create cycle:
        g.addEdge("B", "B");

        System.out.println("has path between A and B? " + g.hasPathBetween("A", "B"));
        System.out.println("has path between A and D? " + g.hasPathBetween("A", "D"));

        g.bfs("A");
        System.out.println();
        g.bfs("B");
        System.out.println("\ndfs Recursive: ");
        g.dfsIterative("B");
        System.out.println("\ndfs Iterative: ");
        g.dfsRecursive("B");

        ///  uses adjacency matrix:

        List<String> elems = new ArrayList<>();
        elems.add("A");
        elems.add("B");
        elems.add("C");
        elems.add("D");

        Graph<String> g2 = new UndirectedGraph<>(elems);

        g2.add("E");

        int adjacencyMatrix[][] = {
                {0, 0, 1, 1, 0}, // Node A
                {0, 0, 1, 1, 1}, // Node B
                {1, 1, 0, 0, 1}, // Node C
                {1, 1, 0, 0, 0}, // Node D
                {0, 1, 1, 0, 0}, // Node E
        };

        System.out.println("\n\nTraversal via BFS starting from 'A':");
        g2.bfs(adjacencyMatrix, "B");

        System.out.println("\n\nTraversal via iterative DFS starting from 'A':");
        g2.dfsIterative(adjacencyMatrix, "A");

        System.out.println("\n\nTraversal via recursive DFS starting from 'A':");
        g2.dfsRecursive(adjacencyMatrix, "A");

    }
}
