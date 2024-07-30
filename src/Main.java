// Name: Boris Alemnka       Course: Software Development 1 (CEN 3024C)       Date: 6/11/2024
//Class Name: Book
//Function: Holds the main library application with all the method invocations
// as well as the return method defined and initialized by data type.

//import java.sql.*;
//import java.time.LocalDate;
//import java.io.*;
import java.util.Scanner;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class Main {
    // private static final LibraryBooks libraryBooks = new LibraryBooks();

    public static void main(String[] args) {
        LibraryBooks libraryBooks = new LibraryBooks();

        System.out.print("Enter the name of the library: ");    //Added some books to already exist in the database
        Scanner scanA = new Scanner(System.in);
        String libraryName = scanA.nextLine();

        LibraryBooks.addNewBook(new Book("1", "Things Fall Apart", "Chinua Achebe", "01"));
        LibraryBooks.addNewBook(new Book("2", "The Black Cat", "Edgar Allan Poe", "02"));
        LibraryBooks.addNewBook(new Book("3", "The Mother Hen", "Jemimah A. Admas", "03"));
        LibraryBooks.addNewBook(new Book("4", "The Dark Knight", "James Bond", "04"));
        LibraryBooks.addNewBook(new Book("5", "When Rain Clouds Gather", "Bessie Head", "05"));
        LibraryBooks.addNewBook(new Book("6", "Anthills of the Savannah", "Chinua Achebe", "06"));

        LibraryBooks.displayAllBooks();

        System.out.println();
        System.out.print("Enter book ID to add: ");  //User input from scanner requesting the fields to add to create new book.
        String id = scanA.nextLine();

        System.out.print("Enter title to add: ");
        String title = scanA.nextLine();

        System.out.print("Enter author to add: ");
        String author = scanA.nextLine();

        System.out.print("Enter barcode to add: ");
        String barcode = scanA.nextLine();
        System.out.println();

        LibraryBooks.addNewBook(new Book(id, title, author, barcode)); //Implementing the add method to add new book to the database.
        System.out.println("Book with title: " + "'" + title + "'" + " added successfully");

        LibraryBooks.displayAllBooks();      //Call to print method to display the content of the database to also include new book added

        System.out.println();
        System.out.print("Enter book Barcode to remove: ");  //Implementing the remove method to remove book from the database.
        String barcodeToRemove = scanA.nextLine();               //Prompts user to enter the barcode of book to remove

        LibraryBooks.removeBookBarcode(barcodeToRemove);    // implementation
        System.out.println();

        LibraryBooks.displayAllBooks();      //Call to print method to display content of database to also exclude the removed book

        System.out.println();
        System.out.print("Enter book title to remove: ");      //Prompts user to enter the title of book to remove (similar to the above)
        String titleToRemove = scanA.nextLine();

        LibraryBooks.removeBookTitle(titleToRemove);     // implementation
        System.out.println();

        LibraryBooks.displayAllBooks();        //Call to print method to display content of database to also exclude the removed book

        System.out.println();
        System.out.print("Enter book title to check out: ");     //Prompts user to enter title of book to check out
        String titleToCheckOut = scanA.nextLine();

        LibraryBooks.checkOutBook(titleToCheckOut);     //Implementation of check out method

        System.out.println();

        LibraryBooks.displayAllBooks();   //Call to print method to display content of database. Also shows status of checked out book and due date

        System.out.println();
        System.out.print("Enter book title to check in: ");  //Prompts user to enter title of book to check back in
        String titleToCheckIn = scanA.nextLine();

        LibraryBooks.checkInBook(titleToCheckIn);    //Implementation of check in method

        LibraryBooks.displayAllBooks();      //Call to print method to display content of database. Also shows updated status and due date
    }
}
