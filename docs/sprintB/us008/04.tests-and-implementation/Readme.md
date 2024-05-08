# US008 - List the vehicles needing the check-up.

## 4. Tests 

**Test 1:** Ensure Vehicles are Correctly Identified for Check-up Based on Current Km and Frequency


	@Test
		public void ensureVehiclesAreCorrectlyIdentifiedForCheckUp() {
    	VehicleRepository vehicleRepository = new VehicleRepository();
    	VehicleService vehicleService = new VehicleService(vehicleRepository);

    	
    	vehicleRepository.add(new Vehicle("123-ABC", "Toyota", "Corolla", 100000, 15000, 85000));
    	vehicleRepository.add(new Vehicle("456-DEF", "Honda", "Civic", 120000, 20000, 100000));

    	
    	List<Vehicle> vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();

    	
    	assertEquals(2, vehiclesNeedingCheckup.size());
    	assertTrue(vehiclesNeedingCheckup.stream().anyMatch(v -> v.getPlateNumber().equals("123-ABC")));
    	assertTrue(vehiclesNeedingCheckup.stream().anyMatch(v -> v.getPlateNumber().equals("456-DEF")));
} 
	

**Test 2:** Validate that Vehicles Not Needing a Check-up are not Listed
	
	@Test
		public void ensureVehiclesNotNeedingCheckUpAreNotListed() {
    	VehicleRepository vehicleRepository = new VehicleRepository();
    	VehicleService vehicleService = new VehicleService(vehicleRepository);

    	
    	vehicleRepository.add(new Vehicle("789-GHI", "Ford", "Fiesta", 5000, 15000, 0));
    	vehicleRepository.add(new Vehicle("012-JKL", "Nissan", "Leaf", 10000, 20000, 0));

    	
    	List<Vehicle> vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();

    	
    	assertTrue(vehiclesNeedingCheckup.isEmpty());
	}

**Test 3**: Check Display of Vehicle Information

	@Test
		public void checkDisplayOfVehicleInformation() {
    	VehicleRepository vehicleRepository = new VehicleRepository();
    	VehicleService vehicleService = new VehicleService(vehicleRepository);
    	VFMUI vfmui = new VFMUI();

    	
    	vehicleRepository.add(new Vehicle("345-MNO", "Mazda", "3", 30000, 15000, 15000));

    	List<Vehicle> vehicles = vehicleService.listVehiclesNeedingCheckUp();
    	vfmui.showVehiclesNeedingCheckUp(vehicles);

    	assertEquals(1, vfmui.getDisplayedVehicles().size());
    	assertEquals("345-MNO", vfmui.getDisplayedVehicles().get(0).getPlateNumber());
}


## 5. Construction (Implementation)

### VFMController



### Class Vehicle




## 6. Integration and Demo 




## 7. Observations

n/a