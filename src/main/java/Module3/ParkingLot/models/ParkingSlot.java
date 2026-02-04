package Module3.ParkingLot.models;

public class ParkingSlot extends BaseModel{
    private String number;
    private ParkingFloor parkingFloor;
    private ParkingSlotStatus slotStatus;
    // only one type of vehicle on every slot
    private VehicleType allowedVehicleType;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public void setAllowedVehicleType(VehicleType allowedVehicleType) {
        this.allowedVehicleType = allowedVehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(ParkingSlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }
}