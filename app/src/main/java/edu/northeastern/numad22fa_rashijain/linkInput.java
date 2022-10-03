package edu.northeastern.numad22fa_rashijain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class linkInput extends AppCompatActivity {

    List<Links> linksList;
    MyApplication myApplication = (MyApplication) this.getApplication();
    EditText add_name, add_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_input);
        linksList = myApplication.getLinksList();
        add_name = findViewById(R.id.entername);
        add_url = findViewById(R.id.enterurl);
    }

    public void goBackToView(View view) {

        Links newLink = new Links(add_name.getText().toString(), add_url.getText().toString());
        linksList.add(newLink);
        Intent intent = new Intent(this, LinkCollector.class).putExtra("MESSAGE", "Code Accepted");;
        startActivity(intent);

    }
}