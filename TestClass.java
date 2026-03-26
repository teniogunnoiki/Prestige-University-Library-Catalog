import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class TestClass {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);  // Scanner for user input
        // Controls main program loop
        boolean session = true;

        // Create library catalog in admin mode
        LibraryCatalog<LibraryItem> library = new LibraryCatalog("Admin Mode");
        Stack<Action> undoStack = new Stack<>();
        Warehouse warehouse = new Warehouse();

        // Add initial book items to catalog
        library.addItem(new Book(1001, "Five Dialogues", "Plato", "2002", "Physical"));
        library.addItem(new Book(1002, "Introduction to Programming", "Daniel Liang", "1998", "Digital"));
        library.addItem(new Book(1003, "Modern Operating Systems", "Andrew S. Tanenbaum", "1992", "Digital"));
        library.addItem(new Book(1407, "The Essential Bible Companion", "John H Walton", "2006", "Digital"));
        library.addItem(new Book(1009, "Nicomachean Ethics", "Aristotle", "2009", "Physical"));

        // Add initial video items to catalog
        library.addItem(new Video(1004, "Harriet", 125));
        library.addItem(new Video(1005, "Microsoft Excel Training 2017", 55));
        library.addItem(new Video(1006, "Hidden Figures", 127));
        library.addItem(new Video(1008, "Charlotte's Web", 97));
        library.addItem(new Video(1010, "Harry Potter and the Sorcerer's Stone", 152));

        // Main menu loop
        while (session) {

            // Display menu options
            System.out.println("");
            System.out.println("Welcome to Prestige University Library Catalog!");
            System.out.println("Main Menu: ");
            System.out.println("1. Display current library");
            System.out.println("2. Add item");
            System.out.println("3. Remove item");
            System.out.println("5. Create Shipment");
            System.out.println("6. View Shipments");
            System.out.println("7. Undo Last Action");
            System.out.println("8. Search for an Item or Shipment");
            System.out.println("9. Exit");
            System.out.print("Enter menu option: ");

            int choice = s1.nextInt();
            s1.nextLine(); // Clear input buffer

            // Option 1: Display and sort library
            if (choice == 1) {
                System.out.println("Displaying all books as entered: \n");
                library.displayLibrary();

                System.out.println("\nDisplaying by type: ");
                for (LibraryItem item : library.getAllItems()) {
                    if (item instanceof Book) {
                        item.getDetails();
                    }
                    if (item instanceof Video) {
                        item.getDetails();
                    }
                }
            }
            // Option 2: Add new item (Book or Video)
            else if (choice == 2) {
                System.out.println("");
                System.out.println("1. Book");
                System.out.println("2. Video");

                int choice1 = s1.nextInt();
                s1.nextLine(); // Clear buffer

                // Add Book
                if (choice1 == 1) {
                    int lastIndex = 1000 + library.size() + 1; // Generate new ID

                    System.out.println("Title of Book: ");
                    String title = s1.nextLine();

                    System.out.println("Name of Author: ");
                    String author = s1.nextLine();

                    System.out.println("Publish Date of Book: ");
                    String publishDate = s1.nextLine();

                    System.out.println("Digital or Physical: ");
                    String category = s1.nextLine();

                    library.addItem(new Book(lastIndex++, title, author, publishDate, category));
                    undoStack.push(new Action("ADD_ITEM", lastIndex - 1));
                    System.out.println("\nBook Added!");
                }

                // Add Video
                else if (choice1 == 2) {
                    int lastIndex = 1000 + library.size() - 1; // Generate new ID

                    System.out.println("Title of Video: ");
                    String title = s1.nextLine();

                    System.out.println("Duration of Video: ");
                    double duration = s1.nextDouble();

                    library.addItem(new Video(lastIndex++, title, duration));
                    undoStack.push(new Action("ADD_ITEM", lastIndex - 1));
                    System.out.println("\nVideo Added!");
                }
            }
            // Option 3: Remove item by ID
            else if (choice == 3) {
                System.out.println("");
                library.displayLibrary();

                System.out.println("\nWhich Item would you like to remove by ID: ");
                int item = s1.nextInt();

                library.findAndRemoveItem(item);
                undoStack.push(new Action("REMOVE_ITEM", item));// Remove selected item
                s1.nextLine(); // Clear buffer
            }
            // Option 4: Create shipment and add item to it
            else if (choice == 4) {

                // Get shipment details
                System.out.print("Enter new Shipment ID: ");
                int newShipmentID = s1.nextInt();
                s1.nextLine(); // Clear buffer

                System.out.print("Enter destination: ");
                String destination = s1.nextLine();
                // Create and register shipment
                Shipment newShipment = new Shipment(newShipmentID, Shipment.Status.PENDING, destination);
                library.createShipment(newShipment);
                System.out.println("Shipment created successfully!");
                // Add item to shipment
                System.out.print("Enter Item ID to add: ");
                int itemID = s1.nextInt();
                s1.nextLine();
                library.addItemToShipment(itemID, newShipmentID);
                undoStack.push(new Action("ADD_TO_SHIPMENT", itemID));
            }
            // Option 6: View all shipments
            else if (choice == 5) {
                library.displayShipments();

            }
            //Option 6: undo item to shipment or catalog
            else if (choice == 6) {
                if (undoStack.isEmpty()) {
                    System.out.println("Nothing to undo.");
                    return;
                }
                Action lastAction = undoStack.pop();
                switch (lastAction.type) {
                    case "ADD_ITEM":
                        int idToRemove = (int) lastAction.data;
                        library.findAndRemoveItem(idToRemove);
                        System.out.println("Undo: Item addition reversed.");
                        break;
                    case "REMOVE_ITEM":
                        LibraryItem item = (LibraryItem) lastAction.data;
                        library.addItem(item);
                        System.out.println("Undo: Item removal reversed.");
                        break;

                    case "ADD_TO_SHIPMENT":
                        int itemID = (int) lastAction.data;
                        library.findAndRemoveItem(itemID);
                        System.out.println("Undo: Removed item from shipment.");
                        break;


                    default:
                        System.out.println("Unknown action.");
                }
            }
            //option 7: searching and sorting
            else if (choice == 7) {
              System.out.println("\nSorting Alphabetically using merge sort");
                List<LibraryItem> sortedItems = SortUtils.mergeSort(library.getAllItems(), SortUtils.compareByTitle);
                for (LibraryItem item : sortedItems) {
                    System.out.println(item.getDetails());
                }


                System.out.println("\nSorting Alphabetically using quick sort");
                SortUtils.quickSort(library.getAllItems(), 0, library.getAllItems().size() - 1, SortUtils.compareByTitle);
                for (LibraryItem item : library.getAllItems()) {
                    System.out.println(item.getDetails());
                }

                SortUtils.quickSort(library.getAllItems(), 0, library.getAllItems().size() - 1, SortUtils.compareByID);
                System.out.print("Are you searching for (1) book or (2)video? Enter an integer: ");
                int ans = s1.nextInt();
                s1.nextLine();
                ArrayList<LibraryItem> filter = new ArrayList<>();
                if(ans ==1) {
                    for (LibraryItem item : library.getAllItems()) {
                        if (item instanceof Book) {
                            filter.add(item);
                        }
                    }
                }else if(ans == 2) {
                    for (LibraryItem item : library.getAllItems()) {
                        if (item instanceof Video) {
                            filter.add(item);
                        }
                    }
                }
                System.out.println("Enter the ID of the Item: ");
                ans = s1.nextInt();
                s1.nextLine();

                int index = SortUtils.binarySearch(filter, ans);
                if (index != -1) {
                    System.out.println("Found: " + library.getAllItems().get(index));
                } else {
                    System.out.println("Item not found.");
                }

            }
            // Option 8: Exit program
            else if (choice == 8) {
                session = false;
            }
        }
    }
}
