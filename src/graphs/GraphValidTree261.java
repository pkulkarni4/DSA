package graphs;

import java.util.HashSet;
import java.util.Set;

/*
LC 261: check if given graph is a valid tree.
Validity of tree - should have connected nodes and no cycle
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
Ex:
n = 5, edges =  [[0, 1], [0, 2], [0, 3], [1, 4]]
output true
 */
public class GraphValidTree261 {
    public static void main(String[] args) {
        Solution261 s = new Solution261();
        int n = 4;
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {0, 3}/*,
                {1, 4}*/
        };
        boolean b = s.isValidTree(n, edges1);
        System.out.println(b);

        n = 5;
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };
        b = s.isValidTree(n, edges2);
        System.out.println(b);

        int[][] edges3 = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };
        b = s.isValidTree(n, edges3);
        System.out.println(b);
    }
}

class Solution261 {
    /*
    1. create a graph
    2. use dfs to check if node has been already visited (apart from parent node). if it is then it is not a tree.
     */
    public boolean isValidTree(int n, int[][] edges) {
        int len = edges.length;

        //printEdges(edges, len);
        Graph<Integer> g = new UndirectedGraph<>();
        for (int i = 0; i < len; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }
        boolean b = g.isValidTree(0, n);
        return b;
    }

    private static void printEdges(int[][] edges, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(edges[i][0] + " " + edges[i][1]);
            System.out.println();
        }
    }
}