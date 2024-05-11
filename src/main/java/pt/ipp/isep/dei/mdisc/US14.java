package pt.ipp.isep.dei.mdisc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class US14 {


        public static void main(String[] args) throws IOException {
            long[] executionTimes = new long[30];
            for (int i = 1; i <= 30; i++) {
                String fileName = "us14_" + i + ".csv";
                long startTime = System.nanoTime();
                // Algoritmo
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                executionTimes[i - 1] = executionTime;
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv", true))) {
                    writer.write(i + "," + executionTime + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            generateGraph(executionTimes);

        }


        public static void generateGraph(long[] executionTimes) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("graph.dot"))) {
                writer.write("graph ExecutionTimes {\n");

                for (int i = 0; i < executionTimes.length; i++) {
                    writer.write("    " + i + " [label=\"File " + (i+1) + "\\nTime " + executionTimes[i] + " ns\"];\n");
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



    }


