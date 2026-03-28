
public class Video extends LibraryItem {
    private double duration;

    public Video() {
        super();
        this.duration = 0.00;
    }

    public Video(int itemID, String title, double duration) {
        super(itemID, title);
        this.duration = duration;
    }

    @Override
    public String getDetails(){
        return "Item ID: "+ getItemID() +" | Video: " + getTitle() + " - " + duration + " minutes";
    }
    @Override
    public String toString() {
        return getDetails();
    }
}
