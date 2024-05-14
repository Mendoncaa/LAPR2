package pt.ipp.isep.dei.mdisc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class IrrigationSystemManager {

    private DataImporter importer = new DataImporter();
    private Graph graph = new Graph();
    private KruskalAlgorithm kruskal = new KruskalAlgorithm();

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do ficheiro:");
        String inputFilePath = scanner.nextLine();

        String outputFilePath = ("output_"+inputFilePath);

        IrrigationSystemManager manager = new IrrigationSystemManager();
        manager.processSingleFile(inputFilePath, outputFilePath);
        manager.performExecutionTimeAnalysis();

        scanner.close();
    }


    public void processSingleFile(String inputFilePath, String outputFilePath) throws IOException {
        List<Edge> edges = importer.importData(inputFilePath);
        for (Edge edge : edges) {
            graph.addEdge(edge.from, edge.to, edge.cost);
        }
        Set<Edge> mst = kruskal.findMinimumSpanningTree(graph);
        exportToCsv(mst, outputFilePath);
        try {
            generateGraph(mst, outputFilePath.replace(".csv", ".png"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void exportToCsv(Set<Edge> mst, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Edge edge : mst) {
                writer.write(edge.from + ";" + edge.to + ";" + edge.cost + "\n");
            }
        }
    }

    private void generateGraph(Set<Edge> mst, String filePath) throws IOException, InterruptedException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("graph.dot"))) {
            writer.write("graph G {\n");
            for (Edge edge : mst) {
                writer.write("    " + edge.from + " -- " + edge.to + " [label=\"" + edge.cost + "\"];\n");
            }
            writer.write("}\n");
        }
        ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", "graph.dot", "-o", filePath);
        try {
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void performExecutionTimeAnalysis() throws IOException, InterruptedException {
        long[] executionTimes = new long[30];
        int[] sizeCounter = new int[30];

        for (int i = 1; i <= 30; i++) {
            String fileName = "us14_" + i + ".csv";
            List<Edge> edges = importer.importData(fileName);

            for (Edge edge : edges) {
                graph.addEdge(edge.from, edge.to, edge.cost);
                sizeCounter[i - 1]++;
            }

            long startTime = System.nanoTime();
            kruskal.findMinimumSpanningTree(graph);
            long endTime = System.nanoTime();
            executionTimes[i - 1] = endTime - startTime;

            graph.clear();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("30Files_ExecutionTimes.csv", true))) {
                writer.write(sizeCounter[i - 1] + ";" + executionTimes[i - 1] + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        generateGnuplot();
    }
    public void generateGnuplot() throws IOException {


        // Cria o arquivo de script Gnuplot
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("gnuplot_script.gp"))) {
            writer.write("# Script Gnuplot para gerar o gráfico\n");
            writer.write("set datafile separator ';'\n");
            writer.write("set terminal pngcairo enhanced font \"arial,10\" fontscale 1.0 size 800, 600\n");
            writer.write("set output \"30Files_ExecutionTimes_plot.png\"\n");
            writer.write("set xlabel \"DataSet Size(Number of Edges)\"\n");
            writer.write("set ylabel \"Execution Time (nanoseconds)\"\n");
            writer.write("set title \"Execution Time vs. Data Set Size\"\n");
            writer.write("plot \"30Files_ExecutionTimes.csv\" with lines");
        }

        // Executa o script Gnuplot
        try {
            ProcessBuilder pb = new ProcessBuilder("gnuplot", "gnuplot_script.gp");
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}

