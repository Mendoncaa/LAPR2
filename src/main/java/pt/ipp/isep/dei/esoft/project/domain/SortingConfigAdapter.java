package pt.ipp.isep.dei.esoft.project.domain;


import java.lang.reflect.Method;
import java.util.List;

public class SortingConfigAdapter implements SortingAlgorithms{
    public List<String> getAllSortingAlgorithmsNames() {
        List<SortingConfigAdaptee.SortingAlgorithmInfo> algorithmsInfo = SortingConfigAdaptee.getSortingAlgorithmsInfo();
        return SortingConfigAdaptee.getSortingAlgorithms(algorithmsInfo);
    }

    public String getSortingAlgorithm(String algorithmName) {
        List<SortingConfigAdaptee.SortingAlgorithmInfo> algorithmsInfo = SortingConfigAdaptee.getSortingAlgorithmsInfo();
        for (SortingConfigAdaptee.SortingAlgorithmInfo info : algorithmsInfo) {
            if (info.getName().equals(algorithmName)) {
                return info.getAlgorithmLogic();
            }
        }
        return null;
    }


    @Override
    public List<GreenSpace> getSortedGreenSpaces(String algorithmName, List<GreenSpace> greenSpaces) {
        String algorithmLogic = getSortingAlgorithm(algorithmName);
        if (algorithmLogic != null) {
            try {
                // Criar uma nova classe dinâmica com o código do algoritmo
                Class<?> dynamicClass = Class.forName("DynamicSortAlgorithm");
                Object instance = dynamicClass.getDeclaredConstructor().newInstance();

                // Chamar o método de ordenação na classe dinâmica
                Method method = dynamicClass.getMethod("sort", List.class);
                return (List<GreenSpace>) method.invoke(instance, greenSpaces);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}








