package edu.northeastern.numad22fa_rashijain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Prime extends AppCompatActivity {

    TextView Current_Number;
    Button Find_Primes;
    TextView Latest_PrimeNumber_Found;
    Button Terminate_Search;
    boolean flag;
    Handler handler;

    Handler handler1;
    int is_prime;
    int num;


    String string1;


    String string2;


    Thread__ myThread;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        this.handler = new Handler();
        this.handler1 = new Handler();
        this.myThread = new Thread__();
        this.Find_Primes = findViewById(R.id.FindPrimes);
        this.Terminate_Search = findViewById(R.id.TerminateSearch);
        this.Current_Number = findViewById(R.id.Current_Number);
        this.Latest_PrimeNumber_Found = findViewById(R.id.LatestPrimeNumberFound);

        this.Find_Primes.setOnClickListener(view -> {
            Prime.this.flag = true;
            Thread__ runnableThread = new Thread__();
            new Thread(runnableThread).start();
        });
        this.Terminate_Search.setOnClickListener(view -> Prime.this.flag = false);
    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to terminate activity?");
        builder.setNegativeButton("Ok", (dialogInterface, i) -> Prime.this.goToActivity());
        builder.setPositiveButton("Cancel", (dialogInterface, i) -> {
        });
        builder.create().show();
    }

    public void goToActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    class Thread__ implements Runnable {
        Thread__() {
        }

        public void run() {
            Prime.this.num = 2;
            while (Prime.this.flag) {
                Prime.this.is_prime = 0;
                for (int i = 2; i <= Prime.this.num; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Prime.this.num % i == 0) {
                        Prime.this.is_prime = 1;
                    }
                    if (Prime.this.is_prime == 0 && i == Prime.this.num - 1) {
                        Prime.this.handler.post(new Thread__() {

                            public void run() {
                                Prime thread_Activity = Prime.this;
                                thread_Activity.string2 = "Latest Prime Number found is:- " + Prime.this.num;
                                Prime.this.Latest_PrimeNumber_Found.setText(Prime.this.string2);
                            }
                        });
                    }
                    Prime.this.handler1.post(new Thread__() {
                        public void run() {
                            Prime.this.string1 = "Current  Number is:- " + Prime.this.num;
                            Prime.this.Current_Number.setText(Prime.this.string1);
                        }
                    });
                }
                Prime.this.num++;
            }
        }
    }


}