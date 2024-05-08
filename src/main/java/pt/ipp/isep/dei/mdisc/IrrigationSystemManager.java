package pt.ipp.isep.dei.mdisc;

import java.io.*;
import java.util.List;
import java.util.Set;


public class IrrigationSystemManager {

    private DataImporter importer = new DataImporter();
    private Graph graph = new Graph();
    private KruskalAlgorithm kruskal = new KruskalAlgorithm();

    public static void main(String[] args) throws IOException, InterruptedException {
        IrrigationSystemManager manager = new IrrigationSystemManager();
        String inputFilePath = "us14_1.csv";
        String outputFilePath = "output.csv";
        manager.processSingleFile(inputFilePath, outputFilePath);
        manager.performPerformanceAnalysis();
    }

    public void performPerformanceAnalysis() throws IOException, InterruptedException {
        long[] executionTimes = new long[30];
        for (int i = 1; i <= 30; i++) {
            String fileName = "us14_" + i + ".csv";
            long startTime = System.nanoTime();
            List<Edge> edges = importer.importData(fileName);
            for (Edge edge : edges) {
                graph.addEdge(edge.from, edge.to, edge.cost);
            }
            Set<Edge> mst = kruskal.findMinimumSpanningTree(graph);
            long endTime = System.nanoTime();
            executionTimes[i - 1] = endTime - startTime;
            graph.clear();
        }
        generateGraph(executionTimes);
    }

    public void processSingleFile(String inputFilePath, String outputFilePath) throws IOException {
        List<Edge> edges = importer.importData(inputFilePath);
        for (Edge edge : edges) {
            graph.addEdge(edge.from, edge.to, edge.cost);
        }
        Set<Edge> mst = kruskal.findMinimumSpanningTree(graph);
        exportToCsv(mst, outputFilePath);
    }

    private void generateGraph(long[] executionTimes) throws IOException, InterruptedException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("graph.dot"))) {
            writer.write("graph ExecutionTimes {\n");
            for (int i = 0; i < executionTimes.length; i++) {
                writer.write("    " + i + " [label=\"File " + (i + 1) + "\\nTime " + executionTimes[i] + " ns\"];\n");
            }
            for (int i = 0; i < executionTimes.length - 1; i++) {
                writer.write("    " + i + " -- " + (i + 1) + ";\n");
            }
            writer.write("}");
        }
    }

    private void exportToCsv(Set<Edge> mst, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Edge edge : mst) {
                writer.write(edge.from + ";" + edge.to + ";" + edge.cost + "\n");
            }
        }
    }

}
