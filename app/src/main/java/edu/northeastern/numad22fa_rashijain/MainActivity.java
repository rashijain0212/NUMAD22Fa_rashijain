package edu.northeastern.numad22fa_rashijain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button About_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToLinkCollector(View view) {
        Intent intent = new Intent(this, LinkCollector.class);
        startActivity(intent);
    }

    public void goToAboutMe(View view) {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

    public void goToAnPrime(View view) {
        Intent intent = new Intent(this, Prime.class);
        startActivity(intent);
    }

    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, AnActivity.class);
        startActivity(intent);
    }
}