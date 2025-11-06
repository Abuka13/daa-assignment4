public class Metrics {
    private long dfsVisits = 0;
    private long edgesExplored = 0;
    private long stackPushes = 0;
    private long stackPops = 0;
    private long relaxations = 0;

    private long startTime = 0;
    private long endTime = 0;

    public void incrementDFSVisits() { dfsVisits++; }


    public void incrementEdgesExplored() { edgesExplored++; }

    public void incrementStackPushes() { stackPushes++; }

    public void incrementStackPops() { stackPops++; }

    public void incrementRelaxations() { relaxations++; }

    public long getDFSVisits() { return dfsVisits; }

    public long getEdgesExplored() { return edgesExplored; }

    public long getStackPushes() { return stackPushes; }

    public long getStackPops() { return stackPops; }

    public long getRelaxations() { return relaxations; }

    public void startTiming() {
        startTime = System.nanoTime();
    }

    public void stopTiming() {
        endTime = System.nanoTime();
    }

    public long getElapsedNanos() {
        return endTime - startTime;
    }

    public double getElapsedMillis() {
        return getElapsedNanos() / 1_000_000.0;
    }

    public void reset() {
        dfsVisits = 0;
        edgesExplored = 0;
        stackPushes = 0;
        stackPops = 0;
        relaxations = 0;
        startTime = 0;
        endTime = 0;
    }

    public String getSummary() {
        return String.format(
                "Metrics Summary:\n" +
                        "  DFS Visits: %d\n" +
                        "  Edges Explored: %d\n" +
                        "  Stack Pushes: %d\n" +
                        "  Stack Pops: %d\n" +
                        "  Relaxations: %d\n" +
                        "  Time: %.3f ms",
                dfsVisits, edgesExplored, stackPushes, stackPops, relaxations, getElapsedMillis()
        );
    }
}