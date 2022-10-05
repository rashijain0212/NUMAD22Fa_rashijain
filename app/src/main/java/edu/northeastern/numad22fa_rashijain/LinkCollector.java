package edu.northeastern.numad22fa_rashijain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class LinkCollector extends AppCompatActivity {

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<Links> linksList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        linksList = myApplication.getLinksList();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecycleViewAdapter(linksList, this);
        recyclerView.setAdapter(mAdapter);
        checkList();

    }
    public void checkList(){
        if(linksList.size() > 0) {
            Snackbar snackbar = Snackbar
                    .make(recyclerView, "link added", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    public void goToLinkInput(View view) {
        Intent intent = new Intent(this, linkInput.class);
        startActivity(intent);
    }


}