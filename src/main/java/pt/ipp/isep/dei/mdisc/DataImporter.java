package pt.ipp.isep.dei.mdisc;
import java.io.*;
import java.util.*;

public class DataImporter {
    public List<Edge> importData(String filePath) throws IOException {
        List<Edge> edges = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                double cost = Double.parseDouble(parts[2].trim());
                edges.add(new Edge(x, y, cost));
            }
        }
        return edges;
    }
}
