// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem book = new Book(1, "java", "abc");
        LibraryItem magazine = new Magazine(2, "python", "xyz");
        LibraryItem dvd = new DVD(3, "c++", "mno");

        // Display details and loan duration using polymorphism
        processItem(book);
        processItem(magazine);
        processItem(dvd);
    }

    public static void processItem(LibraryItem item) {
        item.getItemDetails();
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
    }
}

// Abstract class
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    public abstract int getLoanDuration();
}

// Interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Subclass
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14; // 14 days for books
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Subclass
class Magazine extends LibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 5; // 5 days for DVDs
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}
/*ID: 1, Title: java, Author: abc
Loan Duration: 14 days
ID: 2, Title: python, Author: xyz
Loan Duration: 7 days
ID: 3, Title: c++, Author: mno
Loan Duration: 5 days

 */