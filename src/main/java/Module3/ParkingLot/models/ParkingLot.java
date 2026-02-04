package Module3.ParkingLot.models;

import Module3.ParkingLot.strategy.SlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private int totalCapacity;
    private List<ParkingFloor> parkingFloors;
    private String address;
    private List<Gate> gates;

    public SlotAllocationStrategy getSlotAllotcationStrategy() {
        return slotAllotcationStrategy;
    }

    public void setSlotAllotcationStrategy(SlotAllocationStrategy slotAllotcationStrategy) {
        this.slotAllotcationStrategy = slotAllotcationStrategy;
    }

    private SlotAllocationStrategy slotAllotcationStrategy;
    // status

    // allowedVehicleTypes


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}