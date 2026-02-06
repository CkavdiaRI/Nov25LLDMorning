package Module3.ParkingLot.strategy;

import Module3.ParkingLot.models.ParkingLot;
import Module3.ParkingLot.models.ParkingSlot;
import Module3.ParkingLot.models.VehicleType;

public interface ISlotAllocationStrategy {
    ParkingSlot allotSlot(ParkingLot parkinglot, VehicleType vehicleType);
}
