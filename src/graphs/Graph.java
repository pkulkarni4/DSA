package graphs;

public interface Graph<E> {

    boolean addEdge(E from, E to);

    boolean hasPathBetween(E from, E to);

    void bfs(E startElement);

    void dfsIterative(E startElement);

    void dfsRecursive(E startElement);
}
