package Fifthteen;

import java.util.*;

public class GraphSort {

    // Function to perform the RKPianGraphSort
    public static List<Integer> graphSort(int[] arr) {
        int n = arr.length;
        List<Integer> sortedList = new ArrayList<>();

        // Step 1: Build the adjacency list representation of the graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((i - j) * (arr[i] - arr[j]) >= 0) {
                    graph[i].add(j);
                }
            }
        }

        // Step 2: Compute in-degrees
        int[] inDegree = new int[n];
        for (List<Integer> edges : graph) {
            for (int neighbor : edges) {
                inDegree[neighbor]++;
            }
        }

        // Step 3: Initialize source vertices (with in-degree 0)
        PriorityQueue<Integer> sources = new PriorityQueue<>((a, b) -> Integer.compare(arr[b], arr[a]));
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                sources.add(i);
            }
        }

        // Step 4: Perform topological sorting
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedList.add(arr[vertex]);

            for (int neighbor : graph[vertex]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    sources.add(neighbor);
                }
            }
        }

        return sortedList;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] input = {6, 4, 1, 9, 5, 8, 3, 7, 2};
        System.out.println("Input: " + Arrays.toString(input));

        List<Integer> sorted = graphSort(input);
        System.out.println("Sorted: " + sorted);
    }
}