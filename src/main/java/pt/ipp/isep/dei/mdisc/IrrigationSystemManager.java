package pt.ipp.isep.dei.mdisc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;


public class IrrigationSystemManager {

    private DataImporter importer = new DataImporter();
    private Graph graph = new Graph();
    private KruskalAlgorithm kruskal = new KruskalAlgorithm();

    public static void main(String[] args) throws IOException, InterruptedException {
        IrrigationSystemManager manager = new IrrigationSystemManager();
        String inputFilePath = "US13_JardimDosSentimentos.csv";
        String outputFilePath = "output.csv";
        manager.processSingleFile(inputFilePath, outputFilePath);
        manager.performExecutionTimeAnalysis();
    }


    public void processSingleFile(String inputFilePath, String outputFilePath) throws IOException {
        List<Edge> edges = importer.importData(inputFilePath);
        for (Edge edge : edges) {
            graph.addEdge(edge.from, edge.to, edge.cost);
        }
        Set<Edge> mst = kruskal.findMinimumSpanningTree(graph);
        exportToCsv(mst, outputFilePath);
    }

    private void exportToCsv(Set<Edge> mst, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Edge edge : mst) {
                writer.write(edge.from + ";" + edge.to + ";" + edge.cost + "\n");
            }
        }
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
        ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", "graph.dot", "-o", "graph.png");
        try {
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza uma análise de tempo de execução do algoritmo de Kruskal para diferentes tamanhos de entrada.
     * @throws IOException Se ocorrer um erro de entrada/saída ao escrever os arquivos.
     * @throws InterruptedException Se a execução do processo for interrompida.
     */
    public void performExecutionTimeAnalysis() throws IOException, InterruptedException {
        // Array para armazenar os tempos de execução
        long[] executionTimes = new long[30];
        // Array para contar o número de arestas em cada arquivo de entrada
        int[] sizeCounter = new int[30];

        // Itera sobre os 30 arquivos de entrada
        for (int i = 1; i <= 30; i++) {
            String fileName = "us14_" + i + ".csv";
            // Importa os dados do arquivo CSV
            List<Edge> edges = importer.importData(fileName);

            // Conta o número de arestas e adiciona ao contador
            for (Edge edge : edges) {
                graph.addEdge(edge.from, edge.to, edge.cost);
                sizeCounter[i - 1]++;
            }

            // Mede o tempo de execução do algoritmo de Kruskal
            long startTime = System.nanoTime();
            kruskal.findMinimumSpanningTree(graph);
            long endTime = System.nanoTime();
            executionTimes[i - 1] = endTime - startTime;

            // Limpa o grafo para a próxima iteração
            graph.clear();

            // Escreve os tempos de execução em CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("30Files_ExecutionTimes.csv", true))) {
                writer.write(sizeCounter[i - 1] + ";" + executionTimes[i - 1] + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Gera o gráfico com os tempos de execução
        generateGnuplot();
    }
    /**
     * Gera um gráfico usando Gnuplot com os tempos de execução e os tamanhos do conjunto de dados.
     * @throws IOException Se ocorrer um erro de entrada/saída ao escrever o arquivo de script Gnuplot.
     */
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

