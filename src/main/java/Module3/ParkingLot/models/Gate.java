package Module3.ParkingLot.models;

public class Gate extends BaseModel {
    private String number;
    private GateType type;
    private Operator currentOperator;

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }
}