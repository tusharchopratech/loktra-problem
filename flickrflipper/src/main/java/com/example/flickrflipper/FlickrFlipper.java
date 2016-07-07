package com.example.flickrflipper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlickrFlipper extends AppCompatActivity {

    GridView gridView;
    GridViewData[] imageData;
    GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flickr_flipper);

        imageData = new GridViewData[]{
                new GridViewData(R.drawable.balloon, "balloon", "balloon location", "balloon description"),
                new GridViewData(R.drawable.bird, "bird", "bird location", "bird description"),
                new GridViewData(R.drawable.bjp, "bjp", "bjp location", "bjp description"),
                new GridViewData(R.drawable.cat, "cat", "cat location", "cat description"),
                new GridViewData(R.drawable.cricket, "cricket", "cricket location", "cricket description"),
                new GridViewData(R.drawable.earth, "earth", "earth location", "earth description"),
                new GridViewData(R.drawable.football, "football", "football location", "football description"),
                new GridViewData(R.drawable.hands, "hands", "hands location", "hands description"),
                new GridViewData(R.drawable.lady, "lady", "lady location", "lady description"),
                new GridViewData(R.drawable.srilanka, "srilanka", "srilanka location", "srilanka description")
        };

        gridView = (GridView) findViewById(R.id.gridViewId);
        gridViewAdapter = new GridViewAdapter(imageData,FlickrFlipper.this);
        gridView.setAdapter(gridViewAdapter);

    }

}

