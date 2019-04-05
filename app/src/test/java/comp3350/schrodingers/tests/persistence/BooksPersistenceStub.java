package comp3350.schrodingers.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.business.BookBuilder;
import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.persistence.BooksPersistence;

public class BooksPersistenceStub implements BooksPersistence {

    private List<Book> books; // list of books

    //Constructor
    public BooksPersistenceStub() {

        //initializing the list
        this.books = new ArrayList<>();
        BookBuilder builder = new BookBuilder();

        builder.id(1).name("Annabelle Fights Life").author("Jenny Springs").price("$200").genre("Drama").stock("10").icon("annabellefightslife");
        books.add(builder.buildBook());

        builder.id(2).name("Ember of the Children").author("Sophia Saunders").price("$300").genre("Fantasy").stock("20").icon("emberofthechildren");
        books.add(builder.buildBook());

        builder.id(3).name("Escape from the Hill").author("Kirk Hanson").price("$400").genre("Thriller").stock("30").icon("escapefromthehill");
        books.add(builder.buildBook());

        builder.id(4).name("Here by Choice").author("Nate Fitzgerald").price("$400").genre("Drama").stock("30").icon("herebychoice");
        books.add(builder.buildBook());

        builder.id(5).name("Dangerous Crusaders").author("Alexander Thompson").price("$400").genre("Fantasy").stock("30").icon("dangerouscrusaders");
        books.add(builder.buildBook());

        builder.id(6).name("No Way But Down").author("Jackie Thompson").price("$400").genre("Distopian").stock("30").icon("nowaybutdown");
        books.add(builder.buildBook());

        builder.id(7).name("Other World").author("Jodie Doyle").price("$200").genre("Biographic").stock("10").icon("otherworld");
        books.add(builder.buildBook());

        builder.id(8).name("Survival of the Fittest").author("Danise Chung").price("$300").genre("Fiction").stock("20").icon("survivalofthefittest");
        books.add(builder.buildBook());

        builder.id(9).name("The Bad Boy").author("Margaret Brown").price("$400").genre("Fiction").stock("30").icon("thebadboy");
        books.add(builder.buildBook());

        builder.id(10).name("The Dealer").author("Jackie McDowell").price("$400").genre("Action").stock("30").icon("thedealer");
        books.add(builder.buildBook());

        builder.id(11).name("The Edge of the Universe").author("Nathan Harrington").price("$400").genre("Comedy").stock("30").icon("theedgeoftheuniverse");
        books.add(builder.buildBook());

        builder.id(12).name("The Fourth Wind").author("Quin Whitfield").price("$400").genre("Drama").stock("30").icon("thefourthwind");
        books.add(builder.buildBook());

        builder.id(13).name("The Perfect Child").author("Lucinda Berry").price("$200").genre("Education").stock("10").icon("theperfectchild");
        books.add(builder.buildBook());

        builder.id(14).name("The Red Cord of Marriage").author("Nicole Henderson").price("$300").genre("Fiction").stock("20").icon("theredcordofmarriage");
        books.add(builder.buildBook());

        builder.id(15).name("The Red Planet").author("O.G. Hopkins").price("$400").genre("Space").stock("30").icon("theredplanet");
        books.add(builder.buildBook());

        builder.id(16).name("The Rising Captive").author("Courtney Bishop").price("$400").genre("Fiction").stock("30").icon("therisingcaptive");
        books.add(builder.buildBook());

        builder.id(17).name("The Way We Get By").author("Reed Barron").price("$400").genre("Non-Fiction").stock("30").icon("thewaywegetby");
        books.add(builder.buildBook());

        builder.id(18).name("Thirteen Reasons to Forget You").author("Susan Williams").price("$400").genre("Drama").stock("30").icon("thirteenreasonstoforgetyou");
        books.add(builder.buildBook());

        builder.id(19).name("Twilight Fortress").author("Gregory Barrett").price("$200").genre("Fantasy").stock("10").icon("twilightfortress");
        books.add(builder.buildBook());

        builder.id(20).name("Where is Cecilia?").author("Beatrice Parkins").price("$300").genre("Fiction").stock("20").icon("whereiscecilia");
        books.add(builder.buildBook());

        builder.id(21).name("Whirlwind").author("Natalie Hamilton").price("$400").genre("Non-Fiction").stock("30").icon("whirlwind");
        books.add(builder.buildBook());

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


