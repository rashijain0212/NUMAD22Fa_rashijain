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
    Prime.myThread myThread;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        handler = new Handler();
        handler1 = new Handler();
        myThread = new myThread();
        Find_Primes = findViewById(R.id.FindPrimes);
        Terminate_Search = findViewById(R.id.TerminateSearch);
        Current_Number = findViewById(R.id.Current_Number);
        Latest_PrimeNumber_Found = findViewById(R.id.LatestPrimeNumberFound);

        Find_Primes.setOnClickListener(view -> {
            flag = true;
            Prime.myThread runnableThread = new myThread();
            new Thread(runnableThread).start();
        });
        Terminate_Search.setOnClickListener(view -> flag = false);
    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (flag) {
            builder.setMessage("Do you want to terminate activity while search is going?");

        } else {
            builder.setMessage("Do you want to terminate activity?");
        }
        builder.setNegativeButton("Ok", (dialogInterface, i) -> {
            flag = false;
            Prime.this.goToActivity();
        });
        builder.setPositiveButton("Cancel", (dialogInterface, i) -> {
        });
        builder.create().show();
    }

    public void goToActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    class myThread implements Runnable {
        myThread() {
        }

        public void run() {
            num = 2;
            while (flag) {
                is_prime = 0;
                for (int i = 2; i <= num; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (num % i == 0) {
                        is_prime = 1;
                    }
                    if (is_prime == 0 && i == num - 1) {
                        handler.post(new myThread() {

                            public void run() {
                                Prime thread_Activity = Prime.this;
                                thread_Activity.string2 = "Latest Prime Number found is:- " + num;
                                Latest_PrimeNumber_Found.setText(string2);
                            }
                        });
                    }
                    handler1.post(new myThread() {
                        public void run() {
                            string1 = "Current  Number is:- " + num;
                            Current_Number.setText(string1);
                        }
                    });
                }
                num++;
            }
        }
    }
}