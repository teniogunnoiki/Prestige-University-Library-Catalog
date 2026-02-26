import java.util.ArrayList;
import java.util.List;

public class Branch{
    private int branchID;
    private String name;
    private String location;
    private List<Book> books;

    public Branch(int branchID, String name, String location) {
        this.branchID = branchID;
        this.name = name;
        this.location = location;
        this.books = new ArrayList<>();
    }

    public int getBranchID() {
        return branchID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addBooks(Book book) {
         books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book findBooks(int itemID){
        for(Book b : books){
            if(b.getItemID() == itemID){
                return b;
            }
        }
        return null;
    }
}
