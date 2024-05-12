package pt.ipp.isep.dei.mdisc;

import java.util.*;

public class KruskalAlgorithm {
    private Map<String, String> parent = new HashMap<>();
    private Map<String, Integer> rank = new HashMap<>();

    private void Sort(List<Edge> edges) {
        for (int i = 0; i < edges.size(); i++) {
            for (int j = i + 1; j < edges.size(); j++) {
                if (edges.get(i).compareTo(edges.get(j)) > 0) {
                    // Troca as arestas i e j
                    Edge temp = edges.get(i);
                    edges.set(i, edges.get(j));
                    edges.set(j, temp);
                }
            }
        }
    }

    public Set<Edge> findMinimumSpanningTree(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.getAllEdges());
        Sort(edges);

        initializeUnionFind(graph.getVertices());

        Set<Edge> result = new HashSet<>();
        for (Edge edge : edges) {
            String root1 = find(edge.from);
            String root2 = find(edge.to);
            if (!root1.equals(root2)) {
                result.add(edge);
                union(root1, root2);
            }
        }
        return result;
    }

    private void initializeUnionFind(Set<String> vertices) {
        for (String vertex : vertices) {
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    private String find(String vertex) {
        if (!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent.get(vertex)));  // Path compression
        }
        return parent.get(vertex);
    }

    private void union(String root1, String root2) {
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else if (rank.get(root1) < rank.get(root2)) {
            parent.put(root1, root2);
        } else if (!root1.equals(root2)) {
            parent.put(root2, root1);
            rank.put(root1, rank.get(root1) + 1);
        }
    }
}

