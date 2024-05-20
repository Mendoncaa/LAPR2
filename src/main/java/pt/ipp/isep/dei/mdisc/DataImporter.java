package pt.ipp.isep.dei.mdisc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataImporter {
    public List<Edge> importData(String filePath) throws IOException {
        List<Edge> edges = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String from = parts[0].trim();
                    String to = parts[1].trim();
                    double cost = Double.parseDouble(parts[2].trim());
                    edges.add(new Edge(from, to, cost));
                }
            }
        }
        return edges;
    }
}
