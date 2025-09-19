package graphs;

import java.util.*;

/*
Implementation of undirected graph using adjacency map.
* Also supports adjacency matrix.
 */
public class UndirectedGraph<T> implements Graph<T> {
    private Map<T, List<T>> adjacencyList;
    private List<T> elements;

    public UndirectedGraph(Map<T, List<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public UndirectedGraph(List<T> elements) {
        this.elements = elements;
    }

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<>();
        this.elements = new ArrayList<>();
    }

    @Override
    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
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
    // uses adjacency matrix


    @Override
    public boolean add(T element) {
        if (element == null) return false;
        elements.add(element);
        return true;
    }

    @Override
    public void bfs(int[][] adjacencyMatrix, T element) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        queue.add(element);
        visited.add(element);

        while (!queue.isEmpty()) {
            T t = queue.poll();
            System.out.println(t + " ");
            List<T> adjacents = findAdjacents(adjacencyMatrix, element);
            if (adjacents != null && !adjacents.isEmpty()) {
                for (T elem : adjacents) {
                    if (elem != null && !visited.contains(elem)) {
                        queue.add(elem);
                        visited.add(elem);
                    }
                }
            }
        }
    }

    private List<T> findAdjacents(int[][] adjacencyMatrix, T element) {
        int idx = -1;
        List<T> adjacents = null;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(element)) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            adjacents = new ArrayList<>();
            for (int i = 0; i < adjacencyMatrix[idx].length; i++) {
                if (adjacencyMatrix[idx][i] == 1) {
                    adjacents.add(elements.get(i));
                }
            }
        }
        return adjacents;
    }

    @Override
    public void dfsIterative(int[][] adjacencyMatrix, T element) {
        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();
        stack.add(element);
        visited.add(element);

        while (!stack.empty()) {
            T t = stack.pop();
            System.out.println(t + " ");
            List<T> adjacents = findAdjacents(adjacencyMatrix, t);
            if (adjacents != null && !adjacents.isEmpty()) {
                for (T elem : adjacents) {
                    if (elem != null && !visited.contains(elem)) {
                        stack.add(elem);
                        visited.add(elem);
                    }
                }
            }
        }
    }

    @Override
    public void dfsRecursive(int[][] adjacencyMatrix, T element) {
        Set<T> visited = new HashSet<>();
        dfsRecursive(adjacencyMatrix, element, visited);
    }

    @Override
    public boolean isValidTree(T startElement, int totalNodes) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(startElement);

        while (!stack.isEmpty()) {
            T ele = stack.pop();
            visited.add(ele);
            List<T> adjacents = adjacencyList.get(ele);
            if (adjacents != null && !adjacents.isEmpty()) {
                for (T elem : adjacents) {
                    if (elem != null && !visited.contains(elem)) {
                        stack.push(elem);
                    } else {
                        System.out.println(" contains cycle" + elem);
                        return false;
                    }
                }
            }
        }
        System.out.println("visited size: " + visited.size() + "  total nodes: " + totalNodes);
        return visited.size() == totalNodes;
    }

    private void dfsRecursive(int[][] adjacencyMatrix, T element, Set<T> visited) {
        visited.add(element);
        System.out.println(element + " ");
        List<T> adjacents = findAdjacents(adjacencyMatrix, element);
        if (adjacents != null && !adjacents.isEmpty()) {
            for (T elem : adjacents) {
                if (elem != null && !visited.contains(elem)) {
                    dfsRecursive(adjacencyMatrix, elem, visited);
                }
            }
        }
    }
}
