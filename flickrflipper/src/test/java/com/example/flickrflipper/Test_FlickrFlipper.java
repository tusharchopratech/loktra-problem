package com.example.flickrflipper;

/**
 * Created by tc on 7/7/16.
 */

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.flickrflipper.FlickrFlipper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21,manifest = "src/main/AndroidManifest.xml", packageName = "com.example.flickrflipper")
public class Test_FlickrFlipper {

    FlickrFlipper flickrFlipper;
    GridViewData[] imageData ;
    @Before
    public void setup(){
        flickrFlipper= Robolectric.setupActivity(FlickrFlipper.class);
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
    }

    @Test
    public void checkNulls(){
        assertNotNull(flickrFlipper.gridView);
        assertNotNull(flickrFlipper.imageData);
        assertNotNull(flickrFlipper.gridViewAdapter);
    }

    @Test
    public void test_imageData(){
        for(int i=0;i<imageData.length;i++){
            assertEquals(imageData[i].getDescription(),flickrFlipper.imageData[i].getDescription());
            assertEquals(imageData[i].getLocation(),flickrFlipper.imageData[i].getLocation());
            assertEquals(imageData[i].getName(),flickrFlipper.imageData[i].getName());
            assertEquals(imageData[i].getResourceId(),flickrFlipper.imageData[i].getResourceId());
        }

    }

    @Test
    public void test_GridViewAdapter() {
        GridViewAdapter gridViewAdapter = new GridViewAdapter(imageData, RuntimeEnvironment.application);
        assertEquals(imageData.length, gridViewAdapter.getCount());

    }

    @Test
    public void test_performClick(){
        ImageView imageView=(ImageView) flickrFlipper.gridViewAdapter.linearLayout.findViewById(R.id.imageiew);
        LinearLayout linearLayoutItem=(LinearLayout) flickrFlipper.gridViewAdapter.linearLayout.findViewById(R.id.linearLayoutItem);

        imageView.performClick();
        assertEquals(View.GONE,imageView.getVisibility());
        assertEquals(View.VISIBLE,linearLayoutItem.getVisibility());


        linearLayoutItem.performClick();
        assertEquals(View.VISIBLE,imageView.getVisibility());
        assertEquals(View.GONE,linearLayoutItem.getVisibility());
    }



}
