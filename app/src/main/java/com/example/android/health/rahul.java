package com.example.android.health;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class rahul extends AppCompatActivity {
    VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahul);

        videoview=(VideoView)findViewById(R.id.video_view);

        videoview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.v1));
        videoview.requestFocus();
        videoview.start();
    }
}
