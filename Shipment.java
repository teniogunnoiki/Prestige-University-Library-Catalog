import java.util.Date;
import java.util.ArrayList;
public class Shipment {
    private int shipmentID;
    private Date shipmentDate;
    private String status;
    private ArrayList<LibraryItem> items;

    public Shipment(){
        this.shipmentID = 0;
        this.status = "Pending";
        this.shipmentDate = new Date();
        this.items = new ArrayList<>();
    }
    public Shipment(int shipmentID, String status) {
        this.shipmentID = shipmentID;
        this.shipmentDate = new Date();
        this.status = status;
        this.items = new ArrayList<>();
    }
    public void addItem(LibraryItem item) {
        items.add(item);
    }
    public void deliverShipment() {
        this.status = "Delivered";
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public String getStatus() {
        return status;
    }
    public void updateStatus(String status){
        this.status = status;
    }
    public String toString() {
        return "Shipment ID: " + shipmentID +
                ", Date: " + shipmentDate +
                ", Status: " + status +
                ", Items in Shipment: " + items.size();
    }
}
