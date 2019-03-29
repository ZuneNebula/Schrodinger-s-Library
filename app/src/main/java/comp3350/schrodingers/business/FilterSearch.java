package comp3350.schrodingers.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.schrodingers.objects.Book;

// Class - dedicated to filter search query
public class FilterSearch {

    // Method - Filters search list when user enters search criteria
    public static List<Book> filter(String query, List<Book> bookList, ArrayList<Book> arrayList, AccessBooks bookAccess) {

        List<Book> compareList = new <Book>ArrayList();
        query = query.toLowerCase().trim();
        bookList.clear();

        if (query.length() == 0) {
            bookList.addAll(arrayList);
        } else {

            List<Book> listbyTitle = bookAccess.searchBookByTitle(query);
            compareList.addAll(listbyTitle);
            List<Book> listbyAuthor = bookAccess.searchBookByAuthor(query);
            compareList.addAll(listbyAuthor);

            for (Book item : compareList) {

                if (!bookList.contains(item)) {
                    bookList.add(item);
                }
            }
        }
        return bookList;
    }
}
