package graphs;

public class TestGraph {
    public static void main(String[] args) {
        UndirectedGraph<String> g = new UndirectedGraph<>();
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("D", "E");
        // create cycle:
        g.addEdge("B", "B");

        System.out.println(g.hasPathBetween("A", "B"));
        System.out.println(g.hasPathBetween("A", "D"));

        g.bfs("A");
        System.out.println();
        g.bfs("B");
        System.out.println("\ndfs Recursive: ");
        g.dfsIterative("B");
        System.out.println("\ndfs Iterative: ");
        g.dfsRecursive("B");
    }
}
