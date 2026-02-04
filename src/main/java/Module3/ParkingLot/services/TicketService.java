package Module3.ParkingLot.services;

import Module3.ParkingLot.models.Gate;
import Module3.ParkingLot.models.Ticket;
import Module3.ParkingLot.models.Vehicle;
import Module3.ParkingLot.models.VehicleType;
import Module3.ParkingLot.repositories.GateRepository;
import Module3.ParkingLot.repositories.VehicleRepository;

import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Ticket issueTicket(
        String licensePlate,
        VehicleType vehicleType,
        String ownerName,
        int gateId
    ) {
        // Logic to issue a parking ticket

        // Talk to the database
        // Get gate by gateId
        Optional<Gate> gateOptional = gateRepository.findById(gateId);
        if(gateOptional.isEmpty()) {
            throw new RuntimeException("Invalid Gate Id");
        }
        Gate gate = gateOptional.get();

        // Get the vehicle object from the database if it exist
        Vehicle vehicle = null;
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByLicensePlate(licensePlate);
        if(vehicleOptional.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setLicensePlate(licensePlate);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);

            // Save the vehicle to the database
            vehicleRepository.save(vehicle);
        }
        else{
            vehicle = vehicleOptional.get();
        }


        return  null;
    }
}
