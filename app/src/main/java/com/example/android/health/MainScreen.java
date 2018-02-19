package com.example.android.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    TextView value;
    String  value_from_before_screen;
    LinearLayout reduce,hypertension;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        value=(TextView) findViewById(R.id.username_textview);
        value_from_before_screen=getIntent().getStringExtra("USERNAME");
        value.setText("Welcome "+value_from_before_screen);

        reduce=(LinearLayout) findViewById(R.id.reduce);
        hypertension=(LinearLayout) findViewById(R.id.hypertension);

        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reduce_screen=new Intent(MainScreen.this,Reduce.class);

                startActivity(reduce_screen);
            }
        });

        hypertension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hyper_screen=new Intent(MainScreen.this,Hyper.class);
           startActivity(hyper_screen);
            }
        });


    }
}
