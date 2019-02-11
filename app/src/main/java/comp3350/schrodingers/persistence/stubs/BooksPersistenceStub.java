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
        books.add(new Book("3","The Art of jumping", "Franklin", "$400", "Jumpinig","30","1","pet"));
        books.add(new Book("4","The Art of Dancing", "Ryan", "$400", "Racing","30","1","theartofjumping"));
        books.add(new Book("5","The Art of jumping", "Walker", "$400", "Comedy","30","1","theartofjumping"));
        books.add(new Book("6","Software Engineering", "Ayobami", "$400", "Jumpinig","30","1","theartofjumping"));

    }

    public List<Book> getBooks() {
        List <Book> res = new ArrayList<>();
        res.addAll(this.books);
        return res;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        List <Book> authorBook= new ArrayList<>();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()){
          Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
          if ((nextBook.getAuthor().toLowerCase()).contains(author)){
              authorBook.add(nextBook);
          }

        }
        return authorBook; //returns a list of books by the author.
    }

    @Override
    public Book getBookById(String id){
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
            if (nextBook.getBookID().toLowerCase().contains(id)) {
                return nextBook;
            }

        }//returns a books by the author.
        return null;
    }


    @Override
    public List<Book> getBookByTitle(String title) {
        List <Book> titleBook= new ArrayList<>();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()){
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the title
            if ((nextBook.getBookName().toLowerCase()).contains(title)){
                titleBook.add(nextBook);
            }

        }
        return titleBook; //returns a list of books by the title.
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
        int found;
        found = books.indexOf(newBook);
        if (found>=0){
            books.remove(newBook);
        }

    }
}//end of stub class


