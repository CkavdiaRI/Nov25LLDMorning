package Module3.ParkingLot.repositories;

import Module3.ParkingLot.models.Vehicle;

import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles;
    private static int counter = 0;

    public VehicleRepository(Map<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle save(Vehicle vehicle) {
        counter++;
        vehicle.setId(counter);
        vehicles.put(vehicle.getLicensePlate(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findByLicensePlate(String licensePlate) {
        if(vehicles.containsKey(licensePlate)) {
            return Optional.of(vehicles.get(licensePlate));
        }
        return Optional.empty();
    }

    // Allocate a slot using slot allocation strategy
}
