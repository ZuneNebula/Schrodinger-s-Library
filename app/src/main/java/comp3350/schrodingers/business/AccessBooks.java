package comp3350.schrodingers.business;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.objects.Ratings;
import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.RatingPersistence;
import comp3350.schrodingers.objects.User;

public class AccessBooks {
    private AccessUserInfo accessUserInfo;
    private BooksPersistence booksPersistence;
    private RatingPersistence ratingPersistence;
    //constructor
    public AccessBooks() {
        accessUserInfo = new AccessUserInfo();
        booksPersistence = Services.getBooksPersistence();
        ratingPersistence = Services.getRatePersistence();
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = booksPersistence.getAllBooks();
        return allBooks;
    }

    public List<Ratings> getAllRatings(){
        List<Ratings> allRatings = ratingPersistence.getBookRatings();
        return allRatings;
    }

    public void addRating(int bookid, int rate, String review) throws UserException{
        User user = accessUserInfo.getUser();
        if(user != null)
            ratingPersistence.addBookRatings(bookid, rate, user.getEmail(),review);
        else
            throw new UserException("Not logged in!");
    }

    public List <Ratings> findRatingsByBook(int bookID){
        List<Ratings> ratings = ratingPersistence.getBookRatings();
        List<Ratings> bookRatings = new ArrayList<>();
        Iterator<Ratings> rateIterator = ratings.iterator();
        while (rateIterator.hasNext()) {
            Ratings nextRate = rateIterator.next();  //holds the next rating found in the list
            if (nextRate.getBookID() == bookID ) {
                bookRatings.add(nextRate);
            }

        }//returns a books by the author.
        return bookRatings;
    }

    public Book searchBookById(int id) {
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if (nextBook.getBookID() == id) {
                return nextBook;
            }

        }//returns a books by the author.
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> authorBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if ((nextBook.getAuthor().toLowerCase()).contains(author)) {
                authorBook.add(nextBook);
            }

        }
        return authorBook; //returns a list of books by the author.
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> titleBook = new ArrayList<>();
        List<Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the title
            if ((nextBook.getBookName().toLowerCase()).contains(title)) {
                titleBook.add(nextBook);
            }

        }
        return titleBook; //returns a list of books by the title.
    }

    public List<String> getBookDetails(int id) {

        Book book = searchBookById(id);
        List<String> bookInfo = new ArrayList<>();
        bookInfo.add("Book ID : " + book.getBookID());
        bookInfo.add("Book Title : " + book.getBookName());
        bookInfo.add("Book Author : " + book.getAuthor());
        bookInfo.add("Book Price : " + book.getPrice());
        bookInfo.add("Book Genre : " + book.getGenre());
        bookInfo.add("Book Left In Stock : " + book.getBookStock());
        return bookInfo;
    }

}
