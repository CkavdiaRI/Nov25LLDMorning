package Module3.ParkingLot.services;

import Module3.ParkingLot.models.*;
import Module3.ParkingLot.repositories.GateRepository;
import Module3.ParkingLot.repositories.ParkingLotRepository;
import Module3.ParkingLot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

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
        int gateId,
        int parkingLotId
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

        // Parking Lot repository
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
        if(parkingLotOptional.isEmpty()) {
            throw new RuntimeException("Invalid Parking Lot Id");
        }
        ParkingLot parkingLot = parkingLotOptional.get();

        // Call allocation strategy to get the parking spot for the vehicle
        ParkingSlot parkingSlot = parkingLot.getSlotAllotcationStrategy().allotSlot(parkingLot, vehicle.getVehicleType());

        if(parkingSlot == null) {
            throw new RuntimeException("No parking slot available for the vehicle type");
        }

        // Issue a ticket for the vehicle
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setParkingSlot(parkingSlot);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getCurrentOperator());

        // Save the ticket
            // Create ticket repository and save the ticket to the database

        return  ticket;
    }
}
