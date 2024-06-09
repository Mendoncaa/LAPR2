# US0027 - As a GSM, I need to list all green spaces managed by me.

## 4. Tests 

**Test 1:** Check if the list of green spaces is sorted by size in descending order

    @Test
    public void testSortGreenSpaces_SizeDescending() {
        // Create mock green spaces
        GreenSpace gs1 = new GreenSpace("GreenSpace1", SizeClassification.MEDIUM_SIZED_PARK, 10.0, "Address1", "gsm@this.app");
        GreenSpace gs2 = new GreenSpace("GreenSpace2", SizeClassification.LARGE_SIZED_PARK, 20.0, "Address2", "gsm@this.app");
        GreenSpace gs3 = new GreenSpace("GreenSpace3", SizeClassification.MEDIUM_SIZED_PARK, 15.0, "Address3", "gsm@this.app");

        List<GreenSpace> greenSpaces = Arrays.asList(gs1, gs2, gs3);

        // Mock the method to return these green spaces
        List<GreenSpace> sortedGreenSpaces = controller.sortGreenSpaces("QuickSortAlgorithm");

        // Verify the result
        assertNotNull(sortedGreenSpaces);
        assertEquals(3, sortedGreenSpaces.size());
        assertEquals(gs2, sortedGreenSpaces.get(0));
        assertEquals(gs3, sortedGreenSpaces.get(1));
        assertEquals(gs1, sortedGreenSpaces.get(2));
    }
	


## 5. Construction (Implementation)

### Class CreateJobController 

```java
public Job createJob(String name) {

	
	Employee employee = getEmployeeFromSession();
	Organization organization = getOrganizationRepository().getOrganizationByEmployee(employee);

	newJob = organization.createJob(name);
    
	return newJob;
}
```

### Class Organization

```java
public class GreenSpaces {
    Repositories repositories = Repositories.getInstance();
    public List<GreenSpace> getGreenSpacesManagedByMe(String email) {
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();
        List<GreenSpace> spacesManagedByMe = new ArrayList<>();

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            if (greenSpace.getEmail().equals(email)) {
                spacesManagedByMe.add(greenSpace);
            }
        }

        return spacesManagedByMe;
    }
}


```

```java
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

```

```java
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


```

```java
public interface SortingAlgorithms {
    List<GreenSpace> getSortedGreenSpaces(String algorithm, List<GreenSpace> greenSpaces);
}


```

```java
public class ListGSManagedByMeController {
    private SortingConfigAdapter sortingAdapter;

    /**
     * Retrieves a list of GreenSpaces in the agenda of the current GSM user.
     *
     * @return The list of tasks.
     * @throws IllegalArgumentException If the user is not authorized or if the organization is not found.
     */
    public List<GreenSpace> listThisGsmGreenSpaces() throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository()
                    .getOrganizationByEmployeeEmail(userEmail);
            if (organizationOptional.isPresent()) {
                EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
                Employee employee = employeeRepository.getEmployeeById(userEmail);
                return employee.getGreenSpacesManagedByMe();
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not a GSM authorized.");
        }
    }



    public List<String> getAvailableSortingAlgorithms() {
        return sortingAdapter.getAllSortingAlgorithmsNames();
    }

    public List<GreenSpace> sortGreenSpaces(String algorithmName) {
        List<GreenSpace> greenSpaces = listThisGsmGreenSpaces();
        return sortingAdapter.getSortedGreenSpaces(algorithmName, greenSpaces);
    }
}
```


## 6. Integration and Demo 




## 7. Observations

n/a