package graphs;

import java.util.*;

public class CloneUndirectedGraph133 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n3);
        n4.neighbors.add(n1);

        Solution133 s = new Solution133();
        Node clonedGraph = s.cloneGraph(n1);

        printGraph(clonedGraph);
    }

    private static void printGraph(Node clonedGraph) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(clonedGraph);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (!visited.contains(n)) {
                System.out.println(n.val + " ");
                visited.add(n);
            }
            List<Node> adjacents = n.neighbors;
            for (Node adjacent : adjacents) {
                if (adjacent != null && !visited.contains(adjacent)) {
                    stack.push(adjacent);
                }
            }
        }
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution133 {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> clonedNodes = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        clonedNodes.put(node.val, new Node(node.val)); // empty neighbors
        queue.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            List<Node> neighbors = n.neighbors;
            for (Node neighbor : neighbors) {
                Node value = new Node(neighbor.val);
                if (!clonedNodes.containsKey(neighbor.val)) {
                    clonedNodes.put(value.val, value);
                    queue.add(neighbor);
                }
                // add new neighbor nodes
                clonedNodes.get(n.val).neighbors.add(clonedNodes.get(value.val));
            }
        }
        return clonedNodes.get(node.val);
    }
}