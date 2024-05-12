package pt.ipp.isep.dei.esoft.project.repository.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.domain.service.VehicleService;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class VFMController {

    public List<Vehicle> checkup() {

        VehicleService vehicleService = new VehicleService();

        return vehicleService.listVehiclesNeedingCheckUp();

    }

}

