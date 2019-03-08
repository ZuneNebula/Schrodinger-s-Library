package comp3350.schrodingers.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import comp3350.schrodingers.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder>  {

    private



    @Override
    public Viewholder onCreateViewHolder( ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(Viewholder viewholder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class Viewholder extends RecyclerView.ViewHolder{

        TextView bookName;
        RelativeLayout parentLayout;

        public Viewholder(View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.bookName);
            parentLayout= itemView.findViewById(R.id.cart_layout);
        }
    }
}
