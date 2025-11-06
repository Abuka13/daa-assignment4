import java.util.*;


public class TopologicalSort {


    public static List<Integer> kahn(Graph g, Metrics metrics) {
        int n = g.getN();
        List<List<Integer>> adj = g.getAdjacencyList();
        int[] indeg = new int[n];

        // Compute indegrees
        for (Edge e : g.getEdges()) {
            indeg[e.getV()]++;
            if (metrics != null) metrics.incrementEdgesExplored();
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                if (metrics != null) metrics.incrementStackPushes();
            }
        }

        List<Integer> order = new ArrayList<>();
        if (metrics != null) metrics.startTiming();

        while (!q.isEmpty()) {
            int u = q.poll();
            if (metrics != null) metrics.incrementStackPops();

            order.add(u);
            for (int v : adj.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.add(v);
                    if (metrics != null) metrics.incrementStackPushes();
                }
            }
        }

        if (metrics != null) metrics.stopTiming();

        // Check for cycle
        if (order.size() != n) {
            throw new IllegalStateException("Graph is not a DAG (contains a cycle)");
        }

        if (metrics != null) {
            System.out.println(metrics.getSummary());
        }

        return order;
    }
}
