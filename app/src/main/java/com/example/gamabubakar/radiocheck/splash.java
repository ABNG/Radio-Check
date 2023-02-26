package com.example.gamabubakar.radiocheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class splash extends AppCompatActivity {
RatingBar rb;
int flag=0;
Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rb=findViewById(R.id.ratingBar);
       timer=new Thread(){
          public void run(){
              try{
                  sleep(3000);
              }
              catch(Exception e){
                  e.printStackTrace();
              }
              finally{
                  Intent i=new Intent(splash.this,MainActivity.class);
                  startActivity(i);

              }
          }
        };
       rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            flag=(int)rating;
                if(flag==5) {
                    Toast.makeText(getApplicationContext(),"Thanks for giving 5 star Rating Now App Started",Toast.LENGTH_SHORT).show();
                    timer.start();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}
