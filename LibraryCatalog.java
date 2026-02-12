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

    public void displayLibrary() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
}