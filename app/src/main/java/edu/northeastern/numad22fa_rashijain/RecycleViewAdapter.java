package edu.northeastern.numad22fa_rashijain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Links> linksList;
    Context context;

    public RecycleViewAdapter(List<Links> linksList, Context context) {
        this.linksList = linksList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_url, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        String getURL = linksList.get(position).getURL();
        holder.name.setText(linksList.get(position).getName());
        holder.url.setText(getURL);
        holder.parentLayout.setOnClickListener(view -> {

            if (getURL.startsWith("https://") || getURL.startsWith("http://")) {
                Uri uri = Uri.parse(getURL);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            } else Toast.makeText(context, "Invalid Url", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return linksList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView url;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_box);
            url = itemView.findViewById(R.id.urlbox);
            parentLayout = itemView.findViewById(R.id.one_line);
        }
    }
}
