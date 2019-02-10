package comp3350.schrodingers.Objects;

public class Book {
  private final String bookID;
  private final String bookName;
  private final String author;
  private final String price;
  private final String genre;
  private final String bookStock;
  private final String rating;
  private final int iconId;


    public Book(String bookID, String bookName, String author, String price, String genre, String bookStock, String rating, int iconId) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.bookStock= bookStock;
        this.rating= rating;
        this.iconId = iconId;
    }

    public String getBookID() {
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

    public String getRating() {
        return rating;
    }

    public int getIconId() {
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
                ", rating='" + rating + '\'' +
                ", iconId='" + iconId + '\'' +
                '}';
    }
}
