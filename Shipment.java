import java.util.Date;
import java.util.ArrayList;
import java.util.Comparator;
public class Shipment {
    private int shipmentID;
    private Date shipmentDate;
    public enum Status{
        PENDING, DELIVERED, IN_PROGRESS;
    };
    private String status;
    private ArrayList<LibraryItem> items;
    private String destination;


    public Shipment(){
        this.shipmentID = 0;
        this.status = Status.PENDING;
        this.shipmentDate = new Date();
        this.items = new ArrayList<>();
        this.destination = "Unknown";
    }

  public Shipment(int shipmentID, Status status, String destination) {
        this.shipmentID = shipmentID;
        this.shipmentDate = new Date();
        this.status = status;
        this.items = new ArrayList<>();
        this.destination = destination;
    }
    public void addItem(LibraryItem item) {
        items.add(item);
    }
     public void deliverShipment() {
        this.status = Status.DELIVERED;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

   public Status getStatus() {
        return status;
    }
    public void updateStatus(Status status){
        this.status = status;
    }
    public String getDetails() {
        return "Shipment ID: " + shipmentID +
                ", Date: " + shipmentDate +
                ", Status: " + status +
                ", Items in Shipment: " + items.size();
    }
    public ArrayList<LibraryItem> getItems() {
        return items;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public static Comparator<Shipment> compareByDate = (a, b) -> a.getShipmentDate().compareTo(b.getShipmentDate());
    public static Comparator<Shipment> compareByID = (a, b) -> Integer.compare(a.getShipmentID(), b.getShipmentID());
}
