package Four;

import java.util.*;

public class EdgeDiffForUndirectedGraphs {
    private int dfsTime = 1;
    private int completionTime = 1;
    private final int[] dfsTimeArray;
    private final int[] dfsCompletionTimeArray;
    private final boolean[] visited;
    private final ArrayList<ArrayList<Integer>> adjList;
    private final int numberOfVertices;

    private final Comparator<int[]> edgeComparator = (a, b) -> {
        if(a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }

        return Integer.compare(a[1], b[1]);
    };

    private final Set<int[]> treeEdgeSet = new TreeSet<int[]>(edgeComparator);
    private final Set<int[]> forwardEdgeSet = new TreeSet<int[]>(edgeComparator);
    private final Set<int[]> backEdgeSet = new TreeSet<int[]>(edgeComparator);

    public Set<int[]> getBackEdgeSet() {
        for(int[] edge : treeEdgeSet) {
            backEdgeSet.add(new int[]  {edge[1], edge[0]});
        }
        for(int[] edge : forwardEdgeSet) {
            backEdgeSet.add(new int[]  {edge[1], edge[0]});
        }

        return backEdgeSet;
    }

    public Set<int[]> getTreeEdgeSet() {
        return treeEdgeSet;
    }

    public Set<int[]> getForwardEdgeSet() {
        return forwardEdgeSet;
    }

    public EdgeDiffForUndirectedGraphs(int numberOfVertices) {
        this.adjList = new ArrayList<>();
        for(int i = 0; i < numberOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }
        this.numberOfVertices = numberOfVertices;
        dfsTimeArray = new int[numberOfVertices];
        dfsCompletionTimeArray = new int[numberOfVertices];
        this.visited = new boolean[numberOfVertices];
    }

    public boolean addEdge(int u, int v) {
        if(u < 0 || v < 0 || u >= numberOfVertices || v >= numberOfVertices) {
            return false;
        }

        adjList.get(u).add(v);
        adjList.get(v).add(u);
        return true;
    }

    public void dfs(int node) {

        visited[node] = true;
        dfsTimeArray[node] = dfsTime++;

        for(Integer i : adjList.get(node)) {
            if(!visited[i]) {
                treeEdgeSet.add(new int[]{node, i});
                dfs(i);
            }
        }

        dfsCompletionTimeArray[node] = completionTime++;
    }

    public Map<String, Set<int[]>> classifyEdges() {
        Map<String, Set<int[]>> map = new HashMap<>();
        for(int start = 0; start < numberOfVertices; start++)
            if(!visited[start])
                dfs(start);

        map.put("Tree Edge Set", getTreeEdgeSet());

        classifyForwardEdges();

        map.put("Forward Edge Set", getForwardEdgeSet());
        map.put("Back Edge Set", getBackEdgeSet());

        return map;
    }

    private void classifyForwardEdges() {
        for(int i = 0; i < this.numberOfVertices; i++) {
            for(Integer node : adjList.get(i)) {
                if(
                        dfsTimeArray[i] < dfsTimeArray[node]
                        && dfsCompletionTimeArray[i] > dfsCompletionTimeArray[node]
                ) {
                    int[] edge = new int[]{i, node};
                    if(!treeEdgeSet.contains(edge))
                        forwardEdgeSet.add(edge);
                }
            }
        }
    }
}
