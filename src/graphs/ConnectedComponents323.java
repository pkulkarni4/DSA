package graphs;

import java.util.List;
import java.util.Map;

/*
LC 323
There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
The nodes are numbered from 0 to n - 1. Return the total number of connected components in that graph.

Ex:
input n = 6, edges = [ [0, 1], [1,2], [2,3], [4,5]]
output: 2, 0->1->2->3, 4->5
n = 3, edges = [[0, 1], [0, 2]]
output: 1, 0->1->2
*/
public class ConnectedComponents323 {
    public static void main(String[] args) {
        Solution323 s = new Solution323();
        int n = 4;
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {0, 3}
        };
        int b = s.countComponents(n, edges1);
        System.out.println("actual: " + b + " expected: 1 ");

        n = 6;
        int[][] edges2 = {
                {0, 1},
                {1, 2},
                {2, 3},
                {4, 5}
        };
        b = s.countComponents(n, edges2);
        System.out.println("actual: " + b + " expected: 2 ");

        n = 8;
        int[][] edges3 = {
                {0, 1},
                {2, 3},
                {3, 4},
                {4, 5},
                {6, 7}
        };
        b = s.countComponents(n, edges3);
        System.out.println("actual: " + b + " expected: 3 ");
    }
}

class Solution323 {
    public int countComponents(int n, int[][] edges) {
        int len = edges.length;
        Graph<Integer> g = new UndirectedGraph<>();
        for (int i = 0; i < len; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        int numOfComponents = connectedComponents(n, g);
        //System.out.println("connected components: " + numOfComponents);
        return numOfComponents;
    }

    private void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> adjacencyList) {
        if (visited[node]) return;
        visited[node] = true;
        List<Integer> adjacents = adjacencyList.get(node);
        if (adjacents != null)
            for (int neighbor : adjacents) {
                dfs(neighbor, visited, adjacencyList);
            }
    }

    private int connectedComponents(int n, Graph<Integer> g) {
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, g.getAdjacencyList());
                components++;
            }
        }
        return components;
    }
}
