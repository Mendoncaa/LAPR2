package pt.ipp.isep.dei.esoft.project.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SortingConfigAdaptee {
    public static List<SortingAlgorithmInfo> getSortingAlgorithmsInfo() {
        List<SortingAlgorithmInfo> algorithmsInfo = new ArrayList<>();
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("resources/config.properties")) {
            properties.load(input);
            String sortingAlgorithms = properties.getProperty("sortingAlgorithms");
            if (sortingAlgorithms != null) {
                String[] algorithms = sortingAlgorithms.split(",");
                for (String algorithm : algorithms) {
                    String algorithmName = algorithm.trim();
                    String algorithmLogic = properties.getProperty(algorithmName);
                    algorithmsInfo.add(new SortingAlgorithmInfo(algorithmName, algorithmLogic));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return algorithmsInfo;
    }

    public static List<String> getSortingAlgorithms(List<SortingAlgorithmInfo> algorithmsInfo) {
        List<String> sortingAlgorithms = new ArrayList<>();
        for (SortingAlgorithmInfo info : algorithmsInfo) {
            sortingAlgorithms.add(info.getName());
        }
        return sortingAlgorithms;
    }

    public static class SortingAlgorithmInfo {
        private String algorithmName;
        private String algorithmLogic;

        public SortingAlgorithmInfo(String algorithmName, String algorithmLogic) {
            this.algorithmName = algorithmName;
            this.algorithmLogic = algorithmLogic;
        }

        public String getName() {
            return algorithmName;
        }

        public String getAlgorithmLogic() {
            return algorithmLogic;
        }
    }
}

