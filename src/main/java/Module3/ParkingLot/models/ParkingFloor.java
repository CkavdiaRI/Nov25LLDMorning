package Module3.ParkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private String number;
    private List<ParkingSlot> parkingSlots;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}