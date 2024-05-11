package pt.ipp.isep.dei.mdisc;

import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(int from, int to, double cost) {
        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());
        Edge edge = new Edge(from, to, cost);
        adjacencyList.get(from).add(edge);
        adjacencyList.get(to).add(edge);  // Para grafos não direcionados, adiciona para ambos os vértices
    }

    public List<Edge> getEdges(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Edge> getAllEdges() {
        Set<Edge> allEdges = new HashSet<>();
        for (List<Edge> edges : adjacencyList.values()) {
            allEdges.addAll(edges);
        }
        return allEdges;
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }


    public void clear() {
        adjacencyList.clear();
    }
}

