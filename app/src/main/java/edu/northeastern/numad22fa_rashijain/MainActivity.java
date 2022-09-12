package edu.northeastern.numad22fa_rashijain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button About_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        About_btn = findViewById(R.id.AboutMe);

        About_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                About_Me_Fn();
            }

            private void About_Me_Fn() {
                Toast.makeText(getApplicationContext(),"Name :- Rashi Jain and Email :- jain.ras@northeastern.edu",Toast.LENGTH_LONG).show();
            }
        });
    }
}