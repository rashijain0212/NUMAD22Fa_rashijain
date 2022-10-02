package edu.northeastern.numad22fa_rashijain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LinkAdapter extends RecyclerView.Adapter<LinksViewHolder> {
    private final List<Links> links;
    private final Context context;

    public LinkAdapter(List<Links> links, Context context) {
        this.links = links;
        this.context = context;
    }

    @NonNull
    @Override
    public LinksViewHolder onCreateViewHolder(@NonNull ViewGroup links, int viewType) {
        // Create an instance of the viewholder by passing it the layout inflated as view and no root.
        return new LinksViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person, null));
    }

    @Override
    public void onBindViewHolder(@NonNull LinksViewHolder holder, int position) {
        // sets the name of the person to the name textview of the viewholder.
        holder.name.setText(links.get(position).getName());
        // sets the age of the person to the age textview of the viewholder.
        holder.url.setText(String.valueOf(links.get(position).getURL()));

        // set a click event on the whole itemView (every element of the recyclerview).
        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context, links.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        // Returns the size of the recyclerview that is the list of the arraylist.
        return links.size();
    }
}






