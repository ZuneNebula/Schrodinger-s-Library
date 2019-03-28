package comp3350.schrodingers.presentation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import comp3350.schrodingers.objects.Book;
import comp3350.schrodingers.R;
import comp3350.schrodingers.business.AccessBooks;

import java.util.*;

// Class - handles changing book information into something viewable
public class BookAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Book> bookList;
    private ArrayList<Book> arrayList;
    private AccessBooks bookAccess;

    // Constructor - instantiates book DB access
    public BookAdapter(Context context, AccessBooks access) {

        this.context = context;
        this.bookAccess = access;

        this.bookList = access.getAllBooks();

        inflater = LayoutInflater.from(this.context);
        arrayList = new ArrayList<>();
        this.arrayList.addAll(bookList);

    }

    // Constructor - passed in a list of books
    public BookAdapter(Context context, List<Book> list) {

        this.context = context;
        this.bookList = list;

        inflater = LayoutInflater.from(this.context);
        arrayList = new ArrayList<>();
        this.arrayList.addAll(bookList);

    }

    // Method - holds
    public class ViewHolder {
        TextView title, author;
        ImageView icon;
    }

    // Method - return the size of the booklist
    @Override
    public int getCount() {
        return bookList.size();
    }

    // Method - return book based on selected position
    @Override
    public Book getItem(int position) {
        return bookList.get(position);
    }

    // Method - returns bookID of selected book
    @Override
    public long getItemId(int position) {
        return bookList.get(position).getBookID();
    }

    // Method - instantiate views using book information
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item, null);

            //
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
            // DON'T CARE/UNHANDLABLE - image resources must reside in drawable
            Log.d("BookAdapterException", "Failure to get drawable id.", e);
        }

        holder.icon.setImageResource(iconID);

        // onClick listener for ViewBookInfoActivity
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewBookInfoActivity.class);
                intent.putExtra("id", Integer.toString(bookList.get(position).getBookID()));
                context.startActivity(intent);
            }
        });

        return convertView;
    } // end of getView

    // Method - Filters search list when user enters search criteria
    public void filter(String query) {

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
        notifyDataSetChanged();
    }
}
