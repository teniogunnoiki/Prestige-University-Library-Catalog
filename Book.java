public class Book extends LibraryItem{
    private String publishDate;
    private String category;
    private String author;
    private boolean available;

    public Book(int itemID, String title, String author, String publishDate, String category) {
        super(itemID, title);
        this.author = author;
        this.publishDate = publishDate;
        this.category = category;
        this.available = true;

    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


 public void removeFromCatalog(){
        this.available = false;
    }
    public boolean isAvailable(){
        return this.available;
    }
    @Override
    public String getDetails(){
        return "Item ID: " + getItemID()+ " | Title: " + getTitle() + " | Author: " + author + " | Publish Date: " + publishDate + "| Category: " 
        + category  + " | Avalibility: " + available;
        
    }
}

 