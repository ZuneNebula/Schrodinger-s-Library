package comp3350.schrodingers.application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import comp3350.schrodingers.Objects.Book;
import comp3350.schrodingers.R;
import comp3350.schrodingers.business.FindBook;
import comp3350.schrodingers.presentation.ViewBookInfoActivity;

import java.util.*;

public class BookAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List <Book> bookList;
    ArrayList<Book> arrayList;
    FindBook book;
    List <Book> temp;

    public BookAdapter(Context context, FindBook book) {

        this.context = context;
        this.book = book;


        this.bookList = book.getAllBooks();

        inflater = LayoutInflater.from(this.context);
        arrayList = new ArrayList<Book>();
        this.arrayList.addAll(bookList);

    }


    public class ViewHolder{
        TextView title, author;
        ImageView icon;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item, null);


            holder.title = convertView.findViewById(R.id.bookTitle);
            holder.author = convertView.findViewById(R.id.bookAuthor);
            holder.icon = convertView.findViewById(R.id.bookIcon);

            convertView.setTag(holder);

        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(bookList.get(position).getBookName());
        holder.author.setText(bookList.get(position).getAuthor());
        holder.icon.setImageResource(R.drawable.theartofjumping );    //bookList.get(position).getIconId());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewBookInfoActivity.class);
                intent.putExtra("id",bookList.get(position).getBookID() );
                context.startActivity(intent);
            }
        });


        return convertView;
    } // end of getView

    public void filter(String query){

        System.out.print(book);

        List <Book> compareList  = new <Book> ArrayList();
        query = query.toLowerCase().trim();
        bookList.clear();
        System.out.print(book);
        if(query.length() == 0){
            bookList.addAll(arrayList);
        }
        else{
            List <Book> listbyTitle = book.searchBookByTitle(query);
            compareList.addAll(listbyTitle);
            List <Book> listbyAuthor = book.searchBookByAuthor(query);
            compareList.addAll(listbyAuthor);


            for (Book item : compareList)  {

                if(!bookList.contains(item)){
                    bookList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
