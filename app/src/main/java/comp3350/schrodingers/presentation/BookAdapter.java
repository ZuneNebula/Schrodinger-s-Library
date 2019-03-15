package comp3350.schrodingers.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;

import java.util.ArrayList;
import java.util.List;

// Class - adapts books info stored in DB into a presentable/visual list
public class BookAdapter extends BaseAdapter {

    // Used to store activity context
    private Context adapterContext;

    // Used to convert layout to view
    private LayoutInflater inflater;

    // Lists used to present various books
    private List<Book> bookList;
    private ArrayList<Book> arrayList;

    // DB access
    private AccessBooks bookAccess;

    // Constructor - instantiates adapter
    public BookAdapter(Context context, AccessBooks dbAccess) {

        // Instantiate context
        adapterContext = context;

        // Instantiate DB access
        bookAccess = dbAccess;

        // Store list of books from DB
        bookList = bookAccess.getAllBooks();

        // Instantiate inflater
        inflater = LayoutInflater.from(this.adapterContext);

        // Instantiate booklist as arraylist (easier to work on)
        arrayList = new ArrayList<>();
        arrayList.addAll(bookList);

    }

    // Class - stores views used by all 'search' elements
    public class ViewHolder {
        TextView title, author;
        ImageView icon;
    }

    // Method - return number of books in book list
    @Override
    public int getCount() {
        return bookList.size();
    }

    // Method - return book selected by user
    @Override
    public Book getItem(int position) {
        return bookList.get(position);
    }

    // Method - UNUSED REQUIRED OVERRIDE
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Method - presents the arraylist of books as views
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Create views for each search element
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item, null);


            holder.title = convertView.findViewById(R.id.bookTitle);
            holder.author = convertView.findViewById(R.id.bookAuthor);
            holder.icon = convertView.findViewById(R.id.bookIcon);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        // Set book title and author
        holder.title.setText(bookList.get(position).getBookName());
        holder.author.setText(bookList.get(position).getAuthor());

        // Acquire icon/picture and set as relevant picture
        int iconID = -1;
        try {
            iconID = R.drawable.class.getField(getItem(position).getIconId()).getInt(null);
        } catch (Exception e) {
            System.out.println("Cannot find drawable");
        }

        holder.icon.setImageResource(iconID);

        // Set click listeners on each presented search element
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adapterContext, ViewBookInfoActivity.class);
                intent.putExtra("id", Integer.toString(bookList.get(position).getBookID()));
                adapterContext.startActivity(intent);
            }
        });
        return convertView;
    } // end of getView

    // Method - filters search list based on search criteria
    public void filter(String query) {

        // List for comparison
        List<Book> compareList = new <Book>ArrayList();

        // Converts query to lower case and trims spaces
        query = query.toLowerCase().trim();
        bookList.clear();

        // Adapt list based on search criteria
        if (query.length() == 0) {
            bookList.addAll(arrayList);
        } else {

            // Filter list by title
            List<Book> listbyTitle = bookAccess.searchBookByTitle(query);
            compareList.addAll(listbyTitle);

            // Filter list by author
            List<Book> listbyAuthor = bookAccess.searchBookByAuthor(query);
            compareList.addAll(listbyAuthor);

            // Update presented list
            for (Book item : compareList) {

                if (!bookList.contains(item)) {
                    bookList.add(item);
                }
            }
        }

        // Notify activity that list has changed
        notifyDataSetChanged();
    }
}
