package comp3350.schrodingers.persistence.stubs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comp3350.schrodingers.Objects.Book;
import comp3350.schrodingers.persistence.BooksPersistence;

public class booksPersistenceStub implements BooksPersistence {

    private List<Book> books; // list of books

    //Constructor
    public booksPersistenceStub() {
        //initializing the list
        this.books = new ArrayList<>();
        books.add(new Book("1","The Chronicles of Comp 3150", "Random", "$200", "Educational","10","4"));
        books.add(new Book("2","Adventures of Comp 3150", "Tom", "$300", "Fictional","20","3"));
        books.add(new Book("3","The Art of jumping", "Franklin", "$400", "Jumpinig","30","1"));
    }


    @Override
    public List<Book> getBookByAuthor(String author) {
        List <Book> authorBook= new ArrayList<>();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()){
          Book nextBook = bookIterator.next();  //holds the element to be compared to find the author
          if (nextBook.getAuthor().equals(author)){
              authorBook.add(nextBook);
          }

        }
        return authorBook; //returns a list of books by the author.
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        List <Book> titleBook= new ArrayList<>();
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()){
            Book nextBook = bookIterator.next();  //holds the element to be compared to find the title
            if (nextBook.getBookName().equals(title)){
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


