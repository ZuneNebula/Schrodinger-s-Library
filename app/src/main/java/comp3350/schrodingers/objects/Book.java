package comp3350.schrodingers.objects;

// Class - used to hold all relevant information for a particular book
public class Book {

    // Stores relevant book information
    private final int bookID;
    private final String bookName;
    private final String author;
    private final String price;
    private final String genre;
    private final String bookStock;
    private final String rating;
    private final String iconId;

    // Constructor - creates an instance of a book
    public Book(int bookID, String bookName, String author, String price, String genre, String bookStock, String rating, String iconId) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.bookStock = bookStock;
        this.rating = rating;
        this.iconId = iconId;
    }

    // Method - returns the bookID
    public int getBookID() {
        return bookID;
    }

    // Method - returns the book title
    public String getBookName() {
        return bookName;
    }

    // Method - returns the book author
    public String getAuthor() {
        return author;
    }

    // Method - returns the book price
    public String getPrice() {
        return price;
    }

    // Method - returns the genre of the book
    public String getGenre() {
        return genre;
    }

    // Method - returns the stock/inventory of the associated book
    public String getBookStock() {
        return bookStock;
    }

    // Method - returns the current rating of the book (according the current user)
    public String getRating() {
        return rating;
    }

    // Method - returns the icon/book cover associated with this book
    public String getIconId() {
        return iconId;
    }

    // Method - returns all book info as a string
    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", genre='" + genre + '\'' +
                ", bookStock='" + bookStock + '\'' +
                ", rating='" + rating + '\'' +
                ", iconId='" + iconId + '\'' +
                '}';
    }
}
