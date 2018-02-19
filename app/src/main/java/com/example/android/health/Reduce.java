package com.example.android.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Reduce extends AppCompatActivity {

    RelativeLayout a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduce);

        a=(RelativeLayout)findViewById(R.id.rahul);
        b=(RelativeLayout)findViewById(R.id.sundeep);
        c=(RelativeLayout)findViewById(R.id.serina);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aa=new Intent(Reduce.this,rahul.class);
                startActivity(aa);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bb=new Intent(Reduce.this,sundeep.class);
                startActivity(bb);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cc=new Intent(Reduce.this,tesna.class);
                startActivity(cc);
            }
        });
    }
}
