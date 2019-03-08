package comp3350.schrodingers.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.BooksPersistence;

public class BooksPersistenceStub implements BooksPersistence {

    private List<Book> books; // list of books

    //Constructor
    public BooksPersistenceStub() {
        //initializing the list
        this.books = new ArrayList<>();
        books.add(new Book(1, "Annabelle Fights Life", "Jenny Springs", "$200", "Drama", "10", "4", "annabellefightslife"));
        books.add(new Book(2, "Ember of the Children", "Sophia Saunders", "$300", "Fantasy", "20", "3", "emberofthechildren"));
        books.add(new Book(3, "Escape from the Hill", "Kirk Hanson", "$400", "Thriller", "30", "1", "escapefromthehill"));
        books.add(new Book(4, "Here by Choice", "Nate Fitzgerald", "$400", "Drama", "30", "1", "herebychoice"));
        books.add(new Book(5, "Dangerous Crusaders", "Alexander Thompson", "$400", "Fantasy", "30", "1", "dangerouscrusaders"));
        books.add(new Book(6, "No Way But Down", "Jackie Thompson", "$400", "Distopian", "30", "1", "nowaybutdown"));
        books.add(new Book(7, "Other World", "Jodie Doyle", "$200", "Biographic", "10", "4", "otherworld"));
        books.add(new Book(8, "Survival of the Fittest", "Danise Chung", "$300", "Fiction", "20", "3", "survivalofthefittest"));
        books.add(new Book(9, "The Bad Boy", "Margaret Brown", "$400", "Fiction", "30", "1", "thebadboy"));
        books.add(new Book(10, "The Dealer", "Jackie McDowell", "$400", "Action", "30", "1", "thedealer"));
        books.add(new Book(11, "The Edge of the Universe", "Nathan Harrington", "$400", "Comedy", "30", "1", "theedgeoftheuniverse"));
        books.add(new Book(12, "The Fourth Wind", "Quin Whitfield", "$400", "Drama", "30", "1", "thefourthwind"));
        books.add(new Book(13, "The Perfect Child", "Lucinda Berry", "$200", "Education", "10", "4", "theperfectchild"));
        books.add(new Book(14, "The Red Cord of Marriage", "Nicole Henderson", "$300", "Fiction", "20", "3", "theredcordofmarriage"));
        books.add(new Book(15, "The Red Planet", "O.G. Hopkins", "$400", "Space", "30", "1", "theredplanet"));
        books.add(new Book(16, "The Rising Captive", "Courtney Bishop", "$400", "Fiction", "30", "1", "therisingcaptive"));
        books.add(new Book(17, "The Way We Get By", "Reed Barron", "$400", "Non-Fiction", "30", "1", "thewaywegetby"));
        books.add(new Book(18, "Thirteen Reasons to Forget You", "Susan Williams", "$400", "Drama", "30", "1", "thirteenreasonstoforgetyou"));
        books.add(new Book(19, "Twilight Fortress", "Gregory Barrett", "$200", "Fantasy", "10", "4", "twilightfortress"));
        books.add(new Book(20, "Where is Cecilia?", "Beatrice Parkins", "$300", "Fiction", "20", "3", "whereiscecilia"));
        books.add(new Book(21, "Whirlwind", "Natalie Hamilton", "$400", "Non-Fiction", "30", "1", "whirlwind"));
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(this.books);
        return bookList;
    }


    public Book insertBook(Book newBook) {
        //This function insets the book given has parameter to the List
        books.add(newBook);
        return newBook;
    }


    public void deleteBook(Book newBook) {
        //This function deletes the book given has parameter from the List
        if (books.indexOf(newBook) >= 0)
            books.remove(newBook);
    }
}//end of stub class


