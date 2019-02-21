package comp3350.schrodingers.persistence.stubs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.BooksPersistence;

public class BooksPersistenceStub implements BooksPersistence {

    private List<Book> books; // list of books

    //Constructor
    public BooksPersistenceStub() {
        //initializing the list
        this.books = new ArrayList<>();
        books.add(new Book("1","The Chronicles of Comp 3150", "Random", "$200", "Educational","10","4","reading"));
        books.add(new Book("2","Adventures of Comp 3150", "Tom", "$300", "Fictional","20","3","bookRead"));
        books.add(new Book("3","The Art of Jumping", "Franklin", "$400", "Jumpinig","30","1","pet"));
        books.add(new Book("4","The Art of Dancing", "Ryan", "$400", "Racing","30","1","theartofjumping"));
        books.add(new Book("5","The Art of Walking", "Walker", "$400", "Comedy","30","1","theartofjumping"));
        books.add(new Book("6","Software Engineering", "Ayobami", "$400", "Jumping","30","1","theartofjumping"));

    }

    @Override
    public List<Book> getAllBooks() {
        List <Book> bookList = new ArrayList<>();
        bookList.addAll(this.books);
        return bookList;
    }

    @Override
    public Book insertBook(Book newBook) {
        //This function insets the book given has parameter to the List
        books.add(newBook);
        return newBook;
    }

    @Override
    public void deleteBook(Book newBook) {
        //This function deletes the book given has parameter from the List
        if (books.indexOf(newBook)>=0)
            books.remove(newBook);
    }
}//end of stub class


