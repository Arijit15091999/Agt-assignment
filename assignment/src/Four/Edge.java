package Four;

import java.util.Comparator;

public class Edge {
    int u, v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public Edge reverseEdge() {
        return new Edge(this.v, this.u);
    }


    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return (u == edge.u && v == edge.v);
    }
}
