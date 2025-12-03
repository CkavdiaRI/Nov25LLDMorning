package Module1.Generics.Task1;

public class Clothing extends Item {
    private String size;

    public Clothing(String id, String name, double price, int quantity, String size){
        super(id, name, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", size='" + size + '\'' +
                '}';
    }
}
