import java.util.Date;
public class Shipment {
    private int shipmentID;
    private Date shipmentDate;
    private String status;

    public Shipment(){
        this.shipmentID = 0;
        this.status = "Pending";
        this.shipmentDate = new Date();
    }
    public Shipment(int shipmentID, String status) {
        this.shipmentID = shipmentID;
        this.shipmentDate = new Date();
        this.status = status;
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
                ", Status: " + status;
    }
}
