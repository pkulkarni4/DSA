package graphs;

import java.util.*;

/*
Implementation of undirected graph using adjacency map.
 */
public class UndirectedGraph<T> implements Graph<T> {
    private Map<T, List<T>> adjacencyList;

    public UndirectedGraph(Map<T, List<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public boolean addEdge(T from, T to) {
        if (from == null || to == null) return false;
        List<T> adjacents = adjacencyList.get(from);
        if (adjacents == null) {
            List<T> list = new ArrayList<>();
            list.add(to);
            adjacencyList.put(from, list);
        } else {
            adjacents.add(to);
        }
        return true;
    }

    @Override
    public void bfs(T startElement) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        queue.add(startElement);
        visited.add(startElement);
        while (!queue.isEmpty()) {
            T element = queue.poll();
            System.out.print(" " + element);
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        queue.add(t);
                        visited.add(t);
                    }
                }
            }
        }
    }

    @Override
    public void dfsRecursive(T startElement) {
        Set<T> visited = new HashSet<>();
        dfsRecursive(startElement, visited);
    }

    void dfsRecursive(T startElement, Set<T> visited) {
        visited.add(startElement);
        System.out.print(startElement + " ");
        List<T> adjacency = adjacencyList.get(startElement);
        if (adjacency != null) {
            for (T t : adjacency) {
                if (t != null && !visited.contains(t)) {
                    dfsRecursive(t, visited);
                }
            }
        }
    }

    @Override
    public void dfsIterative(T startElement) {
        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        stack.add(startElement);

        while (!stack.empty()) {
            T element = stack.pop();
            if (!visited.contains(element)) {
                System.out.print(" " + element);
                visited.add(element);
            }
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        stack.push(t);
                    }
                }
            }
        }
    }

    @Override
    public boolean hasPathBetween(T from, T to) {
        if (from == null || to == null) return false;
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            T element = queue.poll();
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        queue.add(t);
                        visited.add(t);
                        // check if we reached destination
                        if (t.equals(to)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
