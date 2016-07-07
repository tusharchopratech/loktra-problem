package com.example.tc.loktra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.flickrflipper.FlickrFlipper;
import com.example.githubapi.GithubActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonGithubApi,buttonFlickrFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFlickrFlipper= (Button) findViewById(R.id.buttonFlickrFlipperId);
        buttonGithubApi= (Button) findViewById(R.id.buttonGithubId);

        buttonGithubApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GithubActivity.class));
            }
        });

        buttonFlickrFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FlickrFlipper.class));
            }
        });
    }
}
