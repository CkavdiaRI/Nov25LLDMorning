package Module3.ParkingLot.repositories;

import Module3.ParkingLot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLots;

    public ParkingLotRepository(Map<Integer, ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Optional<ParkingLot> findById(int id) {
        if (parkingLots.containsKey(id)) {
            return Optional.of(parkingLots.get(id));
        }
        return Optional.empty();
    }
}
