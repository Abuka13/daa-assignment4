import java.util.*;

public class Graph {
    private final int n;
    private final List<Edge> edges;
    private final boolean directed;
    private final Integer source;
    private final String weightModel;

    public Graph(int n, List<Edge> edges, boolean directed, Integer source, String weightModel) {
        this.n = n;
        this.edges = edges;
        this.directed = directed;
        this.source = source;
        this.weightModel = weightModel;
    }

    public int getN() { return n; }
    public List<Edge> getEdges() { return edges; }
    public boolean isDirected() { return directed; }
    public Integer getSource() { return source; }
    public String getWeightModel() { return weightModel; }

    public List<List<Integer>> getAdjacencyList() {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (Edge e : edges) {
            adj.get(e.getU()).add(e.getV());
        }
        return adj;
    }

    public List<List<Integer>> getReverseAdjacencyList() {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (Edge e : edges) {
            adj.get(e.getV()).add(e.getU());
        }
        return adj;
    }
}