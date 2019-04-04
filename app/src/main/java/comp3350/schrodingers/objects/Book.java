package comp3350.schrodingers.objects;

public class Book {

    private final int bookID;
    private final String bookName;
    private final String author;
    private final String price;
    private final String genre;
    private final String bookStock;
    private final String iconId;


    public Book(int bookID, String bookName, String author, String price, String genre, String bookStock, String iconId) {

        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.bookStock = bookStock;
        this.iconId = iconId;

    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }


    public String getBookStock() {
        return bookStock;
    }

    public String getIconId() {
        return iconId;
    }

    @Override
    public String toString() {
        return "Book{" +

                "bookID='" + bookID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", genre='" + genre + '\'' +
                ", bookStock='" + bookStock + '\'' +
                ", iconId='" + iconId + '\'' +
                '}';
    }
}
