package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.persistence.BooksPersistence;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.application.Services;

public class AccessBooks {

    private BooksPersistence booksPersistence;

    //constructor
    public AccessBooks() {
        booksPersistence = Services.getBooksPersistence();
    }

    public List <Book> getAllBooks(){
        List <Book> allBooks = booksPersistence.getAllBooks();
        return allBooks;
    }

    public Book searchBookById(String id){
        List <Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if (nextBook.getBookID().toLowerCase().contains(id)) {
                return nextBook;
            }

        }//returns a books by the author.
        return null;
    }

    public List<Book> searchBookByAuthor(String author){
        List <Book> authorBook= new ArrayList<>();
        List <Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()){
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if ((nextBook.getAuthor().toLowerCase()).contains(author)){
                authorBook.add(nextBook);
            }

        }
        return authorBook; //returns a list of books by the author.
    }

    public List <Book> searchBookByTitle(String title){
        List <Book> titleBook= new ArrayList<>();
        List <Book> books = booksPersistence.getAllBooks();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()){
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the title
            if ((nextBook.getBookName().toLowerCase()).contains(title)){
                titleBook.add(nextBook);
            }

        }
        return titleBook; //returns a list of books by the title.
    }

    public List <String> getBookDetails(String id){

        Book book = searchBookById(id);
        List <String> bookInfo = new ArrayList<>();
        bookInfo.add("Book ID : " + book.getBookID());
        bookInfo.add("Book Title : " + book.getBookName());
        bookInfo.add("Book Author : " + book.getAuthor());
        bookInfo.add("Book Price : " + book.getPrice());
        bookInfo.add("Book Genre : " + book.getGenre());
        bookInfo.add("Book Left In Stock : " + book.getBookStock());
        bookInfo.add("Book Rating : " + book.getRating());
        return bookInfo;
    }

    public void insertBook(Book newBook){
        booksPersistence.insertBook(newBook);
    }

    public void deleteBook(Book book){
        booksPersistence.deleteBook(book);
    }
}
