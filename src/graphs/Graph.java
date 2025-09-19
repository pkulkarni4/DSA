package graphs;

import java.util.List;
import java.util.Map;

public interface Graph<E> {

    Map<E, List<E>> getAdjacencyList();

    boolean addEdge(E from, E to);

    boolean hasPathBetween(E from, E to);

    void bfs(E startElement);

    void dfsIterative(E startElement);

    void dfsRecursive(E startElement);

    boolean add(E element);

    void bfs(int[][] adjacencyMatrix, E element);

    void dfsIterative(int[][] adjacencyMatrix, E element);

    void dfsRecursive(int[][] adjacencyMatrix, E element);

    boolean isValidTree(E startElement, int totalNodes);
}
