import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class mainFrame extends JFrame {
    private LibraryBooks libraryBooks;

    //  private static Map<String, Book> LibraryBooks = new HashMap<>();
    private JTextField tfFileName;
    private JButton btnLoad;
    private JButton btnAddBook;
    private JButton btnClear;
    private JButton btnPrint;
    private JLabel jlWelcome;
    private JPanel mainPanel;
    private JTextField tfFirstName;
    private JLabel jlFirstName;
    private JLabel jlAllBooks;
    private JLabel jlBookID;
    private JTextField tfBookID;
    private JLabel jlTitle;
    private JTextField tfTitle;
    private JLabel jlAuthor;
    private JTextField tfAuthor;
    private JLabel jlBarcode;
    private JTextField tfBarcode;
    private JTextArea textArea1;
    private JList jlistAllBooks;
    private JTextArea textArea2;
    private ArrayList<Book> books;
    private DefaultListModel<Book> listAllBooksModel;

    public mainFrame() {
        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        books = new ArrayList<>();
        listAllBooksModel = new DefaultListModel<>();
        jlistAllBooks = new JList<>(listAllBooksModel);

        jlistAllBooks.setModel(listAllBooksModel);

        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfFirstName.getText();
                String fileName = tfFileName.getText().trim();
                jlWelcome.setText("Welcome to the Library Management System, " + firstName + "!");
                if (firstName.equals("")) {
                    jlWelcome.setText("Please enter a valid first name");
                } else if (fileName.equals("")) {
                    jlWelcome.setText("Please enter a valid file name");
                }
                if (firstName.equals("") && fileName.equals("")) {
                    jlWelcome.setText("Please enter a valid first name and file name");
                }
            }
        });
        jlistAllBooks.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Book selectedBook = (Book) jlistAllBooks.getSelectedValue();
                    if (selectedBook != null) {
                        jlBookID.setText(String.valueOf(selectedBook.getId()));
                        jlTitle.setText(selectedBook.getTitle());
                        jlAuthor.setText(selectedBook.getAuthor());
                        jlBarcode.setText(selectedBook.getBarcode());
                    }
                }
            }
        });
        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlAllBooks.setText(String.valueOf(new Book("1", "The Black Cat", "Edgar Allan Poe", "01")));
                try {
                    String id = tfBookID.getText();
                    String title = tfTitle.getText();
                    String author = tfAuthor.getText();
                    String barcode = tfBarcode.getText();

                    Book newBook = new Book(id, title, author, barcode);
                    books.add(newBook);
                    listAllBooksModel.addElement(newBook);




                    LibraryBooks.book1 = new ArrayList<>();
                    LibraryBooks.addNewBook(newBook);

                    books.add(newBook);
                    LibraryBooks.addNewBook(new Book(id, title, author, barcode));
                    jlAllBooks.setText(String.valueOf(new Book(id, title, author, barcode)));
                    tfBookID.setText("");
                    tfTitle.setText("");
                    tfAuthor.setText("");
                    tfBarcode.setText("");
                }
                catch (NumberFormatException ex) {
                    jlWelcome.setText("Please enter a valid ID");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LibraryBooks.clear();
                tfFileName.setText("");
                jlWelcome.setText("");
                tfFirstName.setText("");
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append(new Book("1", "The Black Cat", "Edgar Poe", "01")).append("\n");
                sb.append(new Book("2", "Things Fall Apart", "Chinua Achebe", "02")).append("\n");

                textArea1.setText(sb.toString());


                sb.append(LibraryBooks.book1.toString()).append("\n");
                textArea2.setText(sb.toString());

                textArea1.setText(LibraryBooks.book1.toString());
                textArea1.setCaretPosition(0);

            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame frame = new mainFrame();
            }
        });
    }
}
