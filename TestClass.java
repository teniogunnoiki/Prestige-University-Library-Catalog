import java.util.Scanner;
public class TestClass {


        
        
    public static void main(String [] args){

        Scanner s1 = new Scanner(System.in);
        boolean session = true;

        LibraryCatalog<LibraryItem> library = new LibraryCatalog("Admin Mode");
        library.addItem(new Book(1001,"Five Dialogues", "Plato", "2002", "Physical"));
        library.addItem(new Book(1002,"Introduction to Programming", "Daniel Liang", "1998", "Digital"));
        library.addItem(new Book(1003,"Modern Operating Systems", "Andrew S. Tanenbaum", "1992", "Digital"));

        library.addItem(new Video(1004, "Harriet", 125));
        library.addItem(new Video(1005, "Microsoft Excel Training 2017", 55));
        library.addItem(new Video(1006, "Hidden Figures", 127));

        
        
        while(session){
        System.out.println("");
        System.out.println("Welcome to Prestige University Library Catalog!");
        System.out.println("Main Menu: ");
        System.out.println("1. Display current library");
        System.out.println("2. Add item");
        System.out.println("3. Remove item");
        System.out.println("4. Exit");
        System.out.println("");
        

        int choice = s1.nextInt();
        s1.nextLine();

        if(choice == 1){
                System.out.println("\nBefore Sorting: ");
                library.displayLibrary();

                library.sortLibrary();
                System.out.println("\nAfter Sorting (Alphabetical by Type");
                library.displayLibrary();
        }
        else if(choice == 2){
                System.out.println("");
                System.out.println("1. Book");
                System.out.println("2. Video");
                int choice1 = s1.nextInt();
                s1.nextLine();
                if(choice1 == 1){
                        int lastIndex = 1000 + library.size() + 1; 
                        System.out.println("Title of Book: ");
                        String title = s1.nextLine();
                        System.out.println("Name of Author: ");
                        String author = s1.nextLine();
                        System.out.println("Publish Date of Book: ");
                        String publishDate = s1.nextLine();
                        System.out.println("Digital or Physical: ");
                        String category = s1.nextLine();
                      
                        library.addItem(new Book(lastIndex++, title, author, publishDate, category));
                        System.out.println("");
                        System.out.println("Book Added! ");
                } else if(choice1 == 2){
                        int lastIndex = 1000 + library.size() - 1;
                        System.out.println("Title of Video: ");
                        String title = s1.nextLine();
                        System.out.println("Duration of Video: ");
                        double duration = s1.nextDouble();
                        library.addItem(new Video(lastIndex++, title, duration));
                        System.out.println("");
                        System.out.println("Video Added!");
                        
                }
        }
        else if(choice == 3){
                System.out.println("");
                library.displayLibrary();
                System.out.println("");
                System.out.println("Which Book would you like to remove by ID: ");
                int item = s1.nextInt();
                library.findandRemoveItem(item);

        }
        else if(choice == 4){
                session = false;
        }
        
        }


    }
}
