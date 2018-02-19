package com.example.android.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout l1, l2;
    Button bt1, bt2;
    Animation up, down, right, left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        //up = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        down = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        right = AnimationUtils.loadAnimation(this, R.anim.move_right);
        left = AnimationUtils.loadAnimation(this, R.anim.move_left);
        // l1.setAnimation(up);
        l2.setAnimation(down);
        bt1.setAnimation(right);
        bt2.setAnimation(left);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,Login.class);
                startActivity(login);
            }


        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,Signup.class);
                startActivity(login);
            }
        });
    }
}
