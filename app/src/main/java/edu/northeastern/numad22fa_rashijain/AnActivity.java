package edu.northeastern.numad22fa_rashijain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnActivity extends AppCompatActivity {
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private Button E;
    private Button F;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        E = findViewById(R.id.E);
        F = findViewById(R.id.F);
        tv = findViewById(R.id.textView);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A_pressed();
            }

            private void A_pressed() {
                tv.setText("Pressed: A");
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                B_pressed();
            }

            private void B_pressed() {
                tv.setText("Pressed: B");

            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                C_pressed();
            }

            private void C_pressed() {
                tv.setText("Pressed: C");

            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                D_pressed();
            }

            private void D_pressed() {
                tv.setText("Pressed: D");

            }
        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E_pressed();
            }

            private void E_pressed() {
                tv.setText("Pressed: E");
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                F_pressed();
            }

            private void F_pressed() {
                tv.setText("Pressed: F");
            }
        });

    }
}