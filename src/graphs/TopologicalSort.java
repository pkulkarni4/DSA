package graphs;

import java.util.*;

public class TopologicalSort<T> {
    public static void main(String[] args) {
        TopologicalSortGraph<String> graph = new TopologicalSortGraph<>();
        graph.addEdge("D", "B");
        graph.addEdge("D", "A");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "F");
        graph.addEdge("B", "E");
        graph.addEdge("E", "G");
        graph.addEdge("G", "H");
        graph.addEdge("A", "C");
        graph.addEdge("C", "F");
        graph.addEdge("F", "G");

        String startNode = "D";
        System.out.println("Topological sort starting from node: " + startNode);
        Stack<String> stack = graph.topologicalSort(startNode);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        // all nodes
        System.out.println("Topological sort for all nodes");
        graph.topologicalSort();
    }
}

class TopologicalSortGraph<T> {
    Map<T, List<T>> adjacencyList;

    public TopologicalSortGraph() {
        adjacencyList = new HashMap<>();
    }

    boolean addEdge(T from, T to) {
        if (from == null || to == null) {
            return false;
        }
        List<T> adjacents = adjacencyList.getOrDefault(from, new ArrayList<T>());
        adjacents.add(to);
        adjacencyList.put(from, adjacents);
        return true;
    }

    void printStack(Stack<T> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    Stack<T> topologicalSort() {
        Set<T> keys = adjacencyList.keySet();
        Stack<T> stack = null;
        for (T key : keys) {
            stack = new Stack<>();
            Set<T> visited = new HashSet<>();
            topologicalSort(key, visited, stack);
            printStack(stack);
        }
        return stack;
    }

    Stack<T> topologicalSort(T startElement) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        topologicalSort(startElement, visited, stack);
        return stack;
    }

    void topologicalSort(T curr, Set<T> visited, Stack<T> stack) {
        visited.add(curr);
        List<T> adjacents = adjacencyList.get(curr);
        if (adjacents != null) {
            for (T adjacent : adjacents) {
                if (adjacent != null && !visited.contains(adjacent)) {
                    topologicalSort(adjacent, visited, stack);
                }
            }
        }
        stack.push(curr);
    }

}