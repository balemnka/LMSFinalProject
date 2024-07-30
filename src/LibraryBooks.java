// Name: Boris Alemnka       Course: Software Development 1 (CEN 3024C)       Date: 6/11/2024
//Class Name: Book
//Function: Holds the book object from where our book title, author, setters and getters methods will be stored
// as well as the return method defined and initialized by data type.
import java.time.LocalDate;
import java.util.ArrayList;

class LibraryBooks {
    public static ArrayList<Book> book1;

    public LibraryBooks() {
        book1 = new ArrayList<>();
    }

    public static void addNewBook(Book book) {
        book1.add(book);
    }   //Defining the add method

    public static void removeBookBarcode(String barcode) {             //Defining the remove method (by barcode)
        Book existingBook = null;
        for (Book book : book1) {
            if (book.getBarcode().equalsIgnoreCase(barcode)) {
                existingBook = book;
                break;
            }
        }
        if (existingBook != null) {
            book1.remove(existingBook);
            System.out.println("Book with Barcode: " + barcode + " successfully deleted");
        } else {
            System.out.println("Book with Barcode: " + barcode + " not found");
        }
    }

    public static void removeBookTitle(String title) {                    //Defining the add method (by title)
        Book existingBook = null;
        for (Book book : book1) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                existingBook = book;
                break;
            }
        }
        if (existingBook != null) {
            book1.remove(existingBook);
            System.out.println("Book with title: " + title + " successfully deleted");
        } else {
            System.out.println("Book with title: " + "'" + title + "'" + " not found");
        }
    }

    public static void checkOutBook(String title) {           //Defining the check out method
        boolean bookFound = false;
        for (Book book : book1) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.setCheckedOut(true);
                book.setStatus("Checked out"); //update method to set status to checked out since it is not available now.
                book.setDueDate(LocalDate.now().plusWeeks(4)); //Date method to calculate the due date
                bookFound = true;
                break;
            }
        }
        if (bookFound) {
            System.out.println("Book with title: " + "'" + title + "'" + " successfully checked out");
        }
        else if (!bookFound) {
                System.out.println("You did not enter a valid book title");
        }
        else {
            System.out.println("Book with title: " + "'" + title + "'" + " already checked out");
        }
    }
    public static void checkInBook(String title) {          //Defining the check in method
        boolean bookFound = true;
        for (Book book : book1) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.setCheckedOut(true);
                book.setStatus("Checked in");     //update method to set the book status to checked in (available)
                book.setDueDate(null);    //update method to set the due date back to null since book is now available
                bookFound = false;
                break;
            }
        }
        if (bookFound) {
            System.out.println("Book with title: " + "'" + title + "'" + " successfully checked in");
        }
        else {
            System.out.println("Book with title: " + "'" + title + "'" + " not checked in");
        }
    }

    public static Book[] displayAllBooks() {        //Defining the print method to display the entire database
        System.out.println("Printing Book Collection");
        for (Book book : book1) {

            System.out.println(book);
        }
        return null;
    }
}