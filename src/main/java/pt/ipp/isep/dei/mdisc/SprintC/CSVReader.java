package pt.ipp.isep.dei.mdisc.SprintC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static int[][] readMatrixFromCSV(String filePath) throws IOException {

        List<int[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    // Remover espaços extras e lidar com possíveis caracteres não numéricos
                    values[i] = values[i].trim();
                    if (values[i].matches("\\d+")) {
                        row[i] = Integer.parseInt(values[i]);
                    } else {
                        row[i] = 0; // Assumir zero se não for um número válido
                    }
                }
                lines.add(row);
            }
        }
        return lines.toArray(new int[0][0]);
    }

    public static String[] readPointsFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            return line.split(";");
        }
    }

    public static void writePathsToCSV(String filePath, List<String> paths) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String path : paths) {
                writer.write(path + "\n\n"); // Adicionar linha em branco entre caminhos
            }
        }
    }
}
