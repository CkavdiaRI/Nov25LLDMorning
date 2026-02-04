package Module3.ParkingLot.repositories;

import Module3.ParkingLot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Integer, Gate> gates;

    public GateRepository() { gates  = new TreeMap<>();}

    public Optional<Gate> findById(int id) {
        if(gates.containsKey(id)) {
            return Optional.of(gates.get(id));
        }
        return Optional.empty();
    }
}
