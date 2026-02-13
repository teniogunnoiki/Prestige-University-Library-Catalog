import java.util.ArrayList;

public class LibraryCatalog<T extends LibraryItem> {
    private String librarySession;
    private ArrayList<T> items = new ArrayList<>();

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
}