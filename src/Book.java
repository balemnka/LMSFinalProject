// Name: Boris Alemnka       Course: Software Development 1 (CEN 3024C)       Date: 6/11/2024
//Class Name: Book
//Function: Holds the book object from where our book title, author, setters and getters methods will be stored
// as well as the return method defined and initialized by data type.

import java.time.LocalDate;
import java.util.ArrayList;

public class Book extends ArrayList<Book> {
                                       // Fields/Variables
    private final String id;
    private final String title;
    private final String author;
    private final String barcode;
    private boolean checkedOut;
    private LocalDate dueDate;
    private String status;
    //private String dueDate;


    public Book(String id, String title, String author, String barcode) {      //Constructor
        this.id = id;
        this.title = title;
        this.author = author;
        this.barcode = barcode;
        this.checkedOut = false;
        this.dueDate = null;
        this.status = "Available";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {                             //Getters and Setters
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getBarcode() {
        return barcode;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Book{" + "ID: " + id + ", Title: " + title + ", Author: " + author + ", Barcode: " + barcode + ", Status: " + status + ", Due Date: " + dueDate + '}';
    }
}