package Thirteen;

import java.util.*;

public class TriangulatedGraphRecognition {
    // Graph representation using adjacency list
    static class Graph {
        private Map<Integer, Set<Integer>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        // Add an edge to the graph
        public void addEdge(int u, int v) {
            adjacencyList.putIfAbsent(u, new HashSet<>());
            adjacencyList.putIfAbsent(v, new HashSet<>());
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // Get neighbors of a vertex
        public Set<Integer> getNeighbors(int v) {
            return adjacencyList.getOrDefault(v, new HashSet<>());
        }

        // Get all vertices in the graph
        public Set<Integer> getVertices() {
            return adjacencyList.keySet();
        }

        // Check if the graph is triangulated using Lexicographic BFS
        public boolean isTriangulated() {
            List<Integer> order = new ArrayList<>();
            Set<Integer> unprocessed = new HashSet<>(getVertices());
            Set<Integer> processed = new HashSet<>();

            while (!unprocessed.isEmpty()) {
                // Find vertex with largest number of neighbors
                int current = -1;
                int maxNeighbors = -1;
                for (int v : unprocessed) {
                    int count = 0;
                    for (int neighbor : getNeighbors(v)) {
                        if (unprocessed.contains(neighbor)) {
                            count++;
                        }
                    }
                    if (count > maxNeighbors) {
                        maxNeighbors = count;
                        current = v;
                    }
                }

                // Add the selected vertex to the order and process it
                order.add(current);
                unprocessed.remove(current);
                processed.add(current);

                // Ensure all neighbors in order form a clique
                for (int u : getNeighbors(current)) {
                    for (int v : getNeighbors(current)) {
                        if (u != v && !getNeighbors(u).contains(v)) {
                            return false;  // Not a chord, graph is not triangulated
                        }
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);

        if (graph.isTriangulated()) {
            System.out.println("The graph is triangulated.");
        } else {
            System.out.println("The graph is not triangulated.");
        }
    }
}
