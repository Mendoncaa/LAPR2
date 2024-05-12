# US008 - List the vehicles needing the check-up.

## 4. Tests 

**Test 1:** Ensure Vehicles that need Check-up are being listed.


	@Test
    public void ensureVehiclesNeedingCheckUpAreListed() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService();

        Vehicle vehicle1 = new Vehicle("789-GHI", "Ford", "Fiesta", "Sedan", 5000, 15000, 4000, "2022-01-01", "2021-01-01", 5000);
        Vehicle vehicle2 = new Vehicle("012-JKL", "Nissan", "Leaf", "Electric", 10000, 20000, 9000, "2023-02-01", "2022-02-01", 10000);

        vehicleRepository.addVehicle(vehicle1);
        vehicleRepository.addVehicle(vehicle2);


        List<Vehicle> vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();

        assertFalse(vehiclesNeedingCheckup.isEmpty());
        assertTrue(vehiclesNeedingCheckup.contains(vehicle1));
        assertTrue(vehiclesNeedingCheckup.contains(vehicle2));
    }
	

**Test 2:** Ensure Vehicles that not need check-up are not being listed.
	
	@Test
    public void ensureVehiclesNotNeedingCheckUpAreNotListed() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService();


        Vehicle vehicle1 = new Vehicle("789-GHI", "Ford", "Fiesta", "Sedan", 5000, 15000, 0, "2022-01-01", "2021-01-01", 5000);
        Vehicle vehicle2 = new Vehicle("012-JKL", "Nissan", "Leaf", "Electric", 10000, 20000, 0, "2023-02-01", "2022-02-01", 10000);

        List<Vehicle> vehiclesNeedingCheckup = new ArrayList<>();
        vehiclesNeedingCheckup.add(vehicle1);
        vehiclesNeedingCheckup.add(vehicle2);

        vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();


        assertTrue(vehiclesNeedingCheckup.isEmpty());
    }

## 5. Construction (Implementation)

### ListVehiclesCheckupController

```java

public class ListVehiclesCheckupController {

    public List<Vehicle> checkup() {

        VehicleService vehicleService = new VehicleService();

        return vehicleService.listVehiclesNeedingCheckUp();

    }

}

```

### Class VehicleService

```java

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService() {
        this.vehicleRepository = Repositories.getInstance().getVehicleRepository();
    }
    public List<Vehicle> listVehiclesNeedingCheckUp() {

        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<Vehicle> vehicleNeedingCheckup = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.calculateNextCheckup() <= 0)  { 

                vehicleNeedingCheckup.add(vehicle);

            }

        }

        return vehicleNeedingCheckup;

    }
}


```


## 6. Integration and Demo 




## 7. Observations

n/a