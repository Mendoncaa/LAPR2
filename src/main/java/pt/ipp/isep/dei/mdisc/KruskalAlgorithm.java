package pt.ipp.isep.dei.mdisc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KruskalAlgorithm {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();

    public Set<Edge> findMinimumSpanningTree(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.getAllEdges());
        Collections.sort(edges);
        initializeUnionFind(graph.getVertices());

        Set<Edge> result = new HashSet<>();
        for (Edge edge : edges) {
            int root1 = find(edge.from);
            int root2 = find(edge.to);
            if (root1 != root2) {
                result.add(edge);
                union(root1, root2);
            }
        }
        return result;
    }

    private void initializeUnionFind(Set<Integer> vertices) {
        for (int vertex : vertices) {
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    private int find(int vertex) {
        if (parent.get(vertex) != vertex) {
            parent.put(vertex, find(parent.get(vertex)));  // Path compression
        }
        return parent.get(vertex);
    }

    private void union(int root1, int root2) {
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else if (rank.get(root1) < rank.get(root2)) {
            parent.put(root1, root2);
        } else if (root1 != root2) {
            parent.put(root2, root1);
            rank.put(root1, rank.get(root1) + 1);
        }
    }
}
