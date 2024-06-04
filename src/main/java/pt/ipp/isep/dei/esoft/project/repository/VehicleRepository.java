package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.CheckUp;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle getVehicleByPlateId(String plateID) {
        if (vehicles == null) {
            return null;
        }
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateID().equals(plateID)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Method to add check-up to a vehicle
    public boolean addCheckUpToVehicle(String plateID, CheckUp checkUp) {
        Vehicle vehicle = getVehicleByPlateId(plateID);
        if (vehicle != null) {
            // Logic to add the check-up to the vehicle
            return true;
        }
        return false;
    }

    public boolean plateIDExists(String plateID) {
        if (vehicles == null) {
            return false;
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateID().equalsIgnoreCase(plateID)) {
                return true;
            }
        }

        return false;
    }

}