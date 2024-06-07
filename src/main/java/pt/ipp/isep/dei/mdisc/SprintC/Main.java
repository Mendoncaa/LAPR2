package pt.ipp.isep.dei.mdisc.SprintC;

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de cálculo de rotas de emergência!");
        System.out.println("Este sistema calcula o caminho mais curto entre um sinal de emergência e o ponto de encontro mais próximo.");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Quer saber o caminho mais próximo até ao ponto de encontro? (US17)");
        System.out.println("2. Cálculo do caminho mais curto para cada sinal até o ponto de encontro mais próximo(US18)");

        int mainChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (mainChoice == 1) {
            runUS17();
        } else if (mainChoice == 2) {
            US18Handler.executeUS18(scanner);
        } else if (mainChoice >= 3) {

        }
    }

    private static void runUS17() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Escolha uma opção:");
        System.out.println("1. Gerar caminho para todos os sinais");
        System.out.println("2. Escolher um sinal específico");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do ficheiro CSV da matriz:");

        String matrixFileName = scanner.nextLine();
        String matrixPath = "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/input/" + matrixFileName;
        System.out.println("Digite o nome do ficheiro para o CSV dos pontos:");

        String pointsFileName = scanner.nextLine();
        String pointsPath = "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/input/" + pointsFileName;

        try {
            int[][] weights = CSVReader.readMatrixFromCSV(matrixPath);
            String[] points = CSVReader.readPointsFromCSV(pointsPath);

            List<Integer> assemblyPoints = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                if (points[i].startsWith("AP")) {
                    assemblyPoints.add(i);
                }
            }

            EmergencyPathFinder epf = new EmergencyPathFinder(weights, points, assemblyPoints);

            if (choice == 1) {
                List<List<Integer>> allPaths = epf.calculateAllPaths();
                List<String> outputPaths = new ArrayList<>();
                for (int i = 0; i < allPaths.size(); i++) {
                    if (!allPaths.get(i).isEmpty()) {
                        String pathString = formatPath(allPaths.get(i), points);
                        String indexPathString = formatIndexPath(allPaths.get(i));
                        int cost = calculatePathCost(allPaths.get(i), weights);
                        outputPaths.add(indexPathString + "; Custo: " + cost + "\n" + pathString + "; Custo total: " + cost);
                        generateDotFile(weights, points, allPaths.get(i), "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_realcado/path_" + points[i] + ".dot");
                        convertDotToPng("src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_realcado/path_" + points[i] + ".dot", "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_realcado/path_" + points[i] + ".png");
                        generateSubgraphDotFile(weights, points, allPaths.get(i), "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_excerto/excerpt_" + points[i] + ".dot");
                        convertDotToPng("src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_excerto/excerpt_" + points[i] + ".dot", "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_excerto/excerpt_" + points[i] + ".png");
                    }
                }
                CSVReader.writePathsToCSV("src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/shortest_routes_all.csv", outputPaths);
            } else if (choice == 2) {
                System.out.println("Digite o nome do sinal:");
                String signal = scanner.nextLine();
                if (Arrays.asList(points).contains(signal)) {
                    int startIdx = Arrays.asList(points).indexOf(signal);
                    int closestAPIdx = -1;
                    int minDist = Integer.MAX_VALUE;
                    for (int apIdx : assemblyPoints) {
                        List<Integer> path = epf.dijkstra(startIdx, apIdx);
                        int dist = path.size() - 1; // assuming each step has uniform cost
                        if (dist < minDist) {
                            minDist = dist;
                            closestAPIdx = apIdx;
                        }
                    }
                    List<Integer> path = epf.dijkstra(startIdx, closestAPIdx);
                    String pathString = formatPath(path, points);
                    String indexPathString = formatIndexPath(path);
                    int cost = calculatePathCost(path, weights);
                    String outputFilePath = "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/shortest_route_" + signal + ".csv";
                    List<String> outputPath = Collections.singletonList(indexPathString + "; Custo: " + cost + "\n" + pathString + "; Custo total: " + cost);
                    CSVReader.writePathsToCSV(outputFilePath, outputPath);
                    generateDotFile(weights, points, path, "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_realcado/path_" + signal + ".dot");
                    convertDotToPng("src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_realcado/path_" + signal + ".dot", "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_realcado/path_" + signal + ".png");
                    generateSubgraphDotFile(weights, points, path, "output/US17/png_excerto/excerpt_" + signal + ".dot");
                    convertDotToPng("src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_excerto/excerpt_" + signal + ".dot", "src/main/java/pt/ipp/isep/dei/mdisc/SprintC/output/US17/png_excerto/excerpt_" + signal + ".png");
                } else {
                    System.out.println("Sinal não encontrado.");
                }
            } else {
                System.out.println("Opção inválida.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatPath(List<Integer> path, String[] points) {
        StringBuilder sb = new StringBuilder();
        for (int index : path) {
            sb.append(points[index]).append(" -> ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 4); // remove the last " -> "
        }
        return sb.toString();
    }

    private static String formatIndexPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int index : path) {
            sb.append((index + 1)).append(" -> ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 4); // remove the last " -> "
        }
        return sb.toString();
    }

    private static int calculatePathCost(List<Integer> path, int[][] weights) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            cost += weights[path.get(i)][path.get(i + 1)];
        }
        return cost;
    }

    private static void generateDotFile(int[][] weights, String[] points, List<Integer> path, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("digraph G {\n");

            for (int i = 0; i < points.length; i++) {
                writer.write("  \"" + points[i] + "\" [label=\"" + points[i] + "\"];\n");
            }

            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < weights[i].length; j++) {
                    if (weights[i][j] > 0) {
                        writer.write("  \"" + points[i] + "\" -> \"" + points[j] + "\" [label=\"" + weights[i][j] + "\"];\n");
                    }
                }
            }

            for (int i = 0; i < path.size() - 1; i++) {
                writer.write("  \"" + points[path.get(i)] + "\" -> \"" + points[path.get(i + 1)] + "\" [color=red, penwidth=2.0];\n");
            }

            writer.write("}\n");
        }
    }

    private static void generateSubgraphDotFile(int[][] weights, String[] points, List<Integer> path, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("digraph G {\n");

            for (int i : path) {
                writer.write("  \"" + points[i] + "\" [label=\"" + points[i] + "\"];\n");
            }

            for (int i = 0; i < path.size() - 1; i++) {
                int from = path.get(i);
                int to = path.get(i + 1);
                writer.write("  \"" + points[from] + "\" -> \"" + points[to] + "\" [label=\"" + weights[from][to] + "\", color=red, penwidth=2.0];\n");
            }

            writer.write("}\n");
        }
    }

    private static void convertDotToPng(String dotFilePath, String pngFilePath) {
        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", dotFilePath, "-o", pngFilePath);
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

