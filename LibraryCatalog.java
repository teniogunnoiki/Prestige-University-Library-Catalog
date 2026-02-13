import java.util.ArrayList;
import java.util.Collections;
public class LibraryCatalog<T extends LibraryItem> {
    private String librarySession;
    private ArrayList<T> items = new ArrayList<>();
    private ArrayList<Shipment> shipments = new ArrayList<>();

    public LibraryCatalog(String librarySession) {
        this.librarySession = librarySession;
    }

    public void addItem(T item) {
        items.add(item);
    }
    public int size(){
        return items.size();
    }

    public void displayLibrary() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
    public void findandRemoveItem(int item){
        boolean found = items.removeIf(s1 -> s1.getItemID() == item);
        if(found) {
            System.out.println("Item Removed!");
        } else {
            System.out.println("Item not found.");
        }
    }
    public void sortLibrary(){
        Collections.sort(items);
    }
    public void addShipment(Shipment shipment){
        shipments.add(shipment);
    }
    public void displayShipments(){
        for(Shipment s : shipments){
            System.out.println(s);
        }
    }
}
