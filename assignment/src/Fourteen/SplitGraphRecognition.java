package Fourteen;

import java.util.*;

public class SplitGraphRecognition {

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

        // Check if the graph is triangulated (chordal)
        public boolean isTriangulated() {
            List<Integer> order = new ArrayList<>();
            Set<Integer> unprocessed = new HashSet<>(getVertices());
            Set<Integer> processed = new HashSet<>();

            while (!unprocessed.isEmpty()) {
                // Find vertex with largest number of unprocessed neighbors
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

        // Check if the graph can be partitioned into a clique and independent set
        public boolean isSplitGraph() {
            if (!isTriangulated()) {
                return false; // If it's not triangulated, it can't be a split graph
            }

            // Try to partition the graph into a clique and independent set
            Set<Integer> clique = new HashSet<>();
            Set<Integer> independentSet = new HashSet<>();

            // Start by considering a vertex for the clique
            Iterator<Integer> iterator = getVertices().iterator();
            if (iterator.hasNext()) {
                int firstVertex = iterator.next();
                clique.add(firstVertex);
            }

            // Now, find the clique (all vertices that are connected to all vertices in the clique)
            for (int vertex : getVertices()) {
                boolean isCliqueMember = true;
                for (int v : clique) {
                    if (!getNeighbors(vertex).contains(v)) {
                        isCliqueMember = false;
                        break;
                    }
                }
                if (isCliqueMember) {
                    clique.add(vertex);
                } else {
                    independentSet.add(vertex);
                }
            }

            // Ensure the independent set has no edges within it
            for (int u : independentSet) {
                for (int v : independentSet) {
                    if (getNeighbors(u).contains(v)) {
                        return false; // Found an edge in the independent set, not a split graph
                    }
                }
            }

            // If we successfully partition the graph, it's a split graph
            return true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        // Example: Adding edges to the graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);

        // Check if the graph is a split graph
        if (graph.isSplitGraph()) {
            System.out.println("The graph is a Split Graph.");
        } else {
            System.out.println("The graph is not a Split Graph.");
        }
    }
}
