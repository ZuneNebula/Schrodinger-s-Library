package comp3350.schrodingers.objects;

public class Book {

    private int bookID = -1;
    private String bookName = null;
    private String author= null;
    private String price= null;
    private String genre= null;
    private String bookStock= null;
    private String iconId= null;

    // constructor
    public Book() {}

    // Setter methods
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setBookStock(String bookStock) {
        this.bookStock = bookStock;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }


    // Getter methods
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
