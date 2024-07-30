import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    //Create object to be tested
    //  private ArrayList<Book> book1;
    private LibraryBooks libraryBooks;

    @BeforeEach
    void setUp() {
        libraryBooks = new LibraryBooks();
    }

    @Test
    @DisplayName("Add Book Test")
    void AddBookTest() {
        Book book = new Book("1", "American History", "Boris Alemnka", "01");
        LibraryBooks.addNewBook(book);
        assertNotEquals(libraryBooks, book);
        System.out.println(book);
    }
    @Test
    @DisplayName("Remove Book Barcode Test")
    void RemoveBookBarcodeTest() {
        Book book2 = new Book("3", "Lone Ranger", "Boris Alemnka", "03");

        LibraryBooks.addNewBook(book2);

        System.out.println(book2);
        LibraryBooks.removeBookBarcode("03");
        book2.setStatus("Not Available");
        assertNotEquals(libraryBooks, book2);
        System.out.println(book2);
        LibraryBooks.removeBookBarcode("03");
    }

    @Test
    @DisplayName("Remove Book Title Test")
    void RemoveBookTitleTest() {
        Book book3 = new Book("2", "Things Fall Apart", "Chinua Achebe", "02");

        LibraryBooks.addNewBook(book3);

        System.out.println(book3);
        LibraryBooks.removeBookTitle("Things Fall Apart");
        book3.setStatus("Not Available");
        assertNotEquals(libraryBooks, book3);
        System.out.println(book3);
        LibraryBooks.removeBookTitle("Things Fall Apart");
    }
    @Test
    @DisplayName("Check Out Book Test")
    void CheckOutBookTest() {
        Book book4 = new Book("4", "The Black Cat", "Edgar Allan Poem", "04");
        LibraryBooks.addNewBook(book4);
        assertFalse(book4.isCheckedOut());

        LibraryBooks.checkOutBook("The Black Cat");
        System.out.println(book4);
    }
    @Test
    @DisplayName("Check In Book Test")
    void CheckInBookTest() {
        Book book5 = new Book("5", "When Rain Clouds Gather", "Bessie Head", "05");
        LibraryBooks.addNewBook(book5);
        assertFalse(book5.isCheckedOut());
        LibraryBooks.checkInBook("When Rain Clouds Gather");
        book5.setStatus("Checked in");
        assertFalse(book5.isCheckedOut());
        System.out.println(book5);
    }
}