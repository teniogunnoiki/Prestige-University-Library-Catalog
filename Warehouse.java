import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private int warehouseID;
    private String location;
    private List<Shipment> shipments;

    public Warehouse(int warehouseID, String location) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.shipments = new ArrayList<>();
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public String getLocation() {
        return location;
    }

    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    public Shipment findShipment(int shipmentID) {
        for (Shipment s : shipments) {
            if (s.getShipmentID() == shipmentID) {
                return s;
            }
        }
        return null;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }
}
