package edu.northeastern.numad22fa_rashijain;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinksViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView url;

    public LinksViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name);
        this.url = itemView.findViewById(R.id.url);
    }
}

}
