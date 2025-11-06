public class Edge {
    private final int u;
    private final int v;
    private final int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int getU() { return u; }
    public int getV() { return v; }
    public int getW() { return w; }

    @Override
    public String toString() {
        return String.format("(%d -> %d, w=%d)", u, v, w);
    }
}