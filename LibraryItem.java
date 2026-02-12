import java.util.Date;
public abstract class LibraryItem {
    private int itemID;
    private String title;
    private Date dateEntered;

    public LibraryItem(){}
    public LibraryItem(int itemID, String title){
        this.itemID = itemID;
        this.title = title;
        this.dateEntered = new Date();
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public abstract String getDetails();

}
