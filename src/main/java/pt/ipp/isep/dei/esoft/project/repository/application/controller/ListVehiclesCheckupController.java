package pt.ipp.isep.dei.esoft.project.repository.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.service.VehicleService;

import java.util.List;

public class ListVehiclesCheckupController {

    public List<Vehicle> checkup() {

        VehicleService vehicleService = new VehicleService();

        return vehicleService.listVehiclesNeedingCheckUp();

    }

}

