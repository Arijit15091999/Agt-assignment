package Twelve;
import java.util.*;

public class GreedyMatching {

    // Method to find the matching in the graph
    public static Set<Edge> findGreedyMatching(Graph graph) {
        Set<Edge> matchingSet = new HashSet<>();
        Set<Integer> matchedVertices = new HashSet<>();

        // Traverse each edge in the graph
        for (Edge edge : graph.getEdges()) {
            int u = edge.getU();
            int v = edge.getV();

            // Add the edge to the matching set if neither vertex is already matched
            if (!matchedVertices.contains(u) && !matchedVertices.contains(v)) {
                matchingSet.add(edge);
                matchedVertices.add(u);
                matchedVertices.add(v);
            }
        }

        return matchingSet;
    }

    public static void main(String[] args) {
        // Create a sample graph
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Find the matching
        Set<Edge> matchingSet = findGreedyMatching(graph);

        // Output the matching set
        System.out.println("Matching Set:");
        for (Edge edge : matchingSet) {
            System.out.println(edge);
        }
    }
}

// Edge class representing an edge in the graph
class Edge {
    private int u, v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    @Override
    public String toString() {
        return "(" + u + ", " + v + ")";
    }
}

// Graph class representing a graph with vertices and edges
class Graph {
    private List<Edge> edges;

    public Graph() {
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        edges.add(new Edge(u, v));
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
