package Four;

import java.util.*;

public class EdgeDiffForDirectedGraph {
    private final int numberOfVertices;

    // color 1 -> white
    // color 2 -> gray
    // color 3 -> black
    private final int[] color;
    private int dfsTime;
    private int dfsCompletionTime;
    private final int[] dfsTimeArray;
    private final int[] dfsCompletionTimeArray;
    private final ArrayList<ArrayList<Integer>> adjList;

    private final Comparator<int[]> edgeComparator = (a, b) -> {
        if(a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }

        return Integer.compare(a[1], b[1]);
    };

    private final Set<int[]> treeEdgeSet = new TreeSet<int[]>(edgeComparator);
    private final Set<int[]> forwardEdgeSet = new TreeSet<int[]>(edgeComparator);
    private final Set<int[]> backEdgeSet = new TreeSet<int[]>(edgeComparator);
    private final Set<int[]> crossEdgeSet = new TreeSet<int[]>(edgeComparator);

    public EdgeDiffForDirectedGraph(int numberOfVertices) {
        this.dfsTime = 1;
        this.dfsCompletionTime = 1;
        this.numberOfVertices = numberOfVertices;
        this.color = new int[numberOfVertices];
        this.adjList = new ArrayList<ArrayList<Integer>>();
        this.dfsTimeArray = new int[numberOfVertices];
        this.dfsCompletionTimeArray = new int[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        Arrays.fill(color, 1);
    }

    public Set<int[]> getTreeEdgeSet() {
        return treeEdgeSet;
    }

    public Set<int[]> getForwardEdgeSet() {
        return forwardEdgeSet;
    }

    public Set<int[]> getBackEdgeSet() {
        return backEdgeSet;
    }


    public Set<int[]> getCrossEdgeSet() {
        return crossEdgeSet;
    }

    public boolean addEdge(int u, int v) {
        if(u < 0 || v < 0 || u >= numberOfVertices || v >= numberOfVertices) {
            return false;
        }

        adjList.get(u).add(v);
//        adjList.get(v).add(u);
        return true;
    }

    public Map<String, Set<int[]>> classifyEdges() {
        Map<String, Set<int[]>> map = new HashMap<>();

        for(int start = 0; start < numberOfVertices; start++) {
            if(color[start] == 1)
                classifyEdgesHelper(start);
        }

        map.put("Tree Edge Set", getTreeEdgeSet());
        map.put("Forward Edge Set", getForwardEdgeSet());
        map.put("Back Edge Set", getBackEdgeSet());
        map.put("Cross Edge Set", getCrossEdgeSet());

        return map;
    }

    private void classifyEdgesHelper(int root) {
        color[root] = 2;
        dfsTimeArray[root] = dfsTime++;

        for(Integer node : adjList.get(root)) {
            int[] edge = new int[] {root, node};
            if(color[node] == 3) {
                if(dfsTimeArray[root] < dfsTimeArray[node]) {
                    forwardEdgeSet.add(edge);
                }else{
                    crossEdgeSet.add(edge);
                }
            }else if(color[node] == 2) {
                backEdgeSet.add(edge);
            }else{
                treeEdgeSet.add(edge);
                classifyEdgesHelper(node);
            }
        }

        color[root] = 3;
        dfsCompletionTimeArray[root] = dfsCompletionTime++;
    }
}
