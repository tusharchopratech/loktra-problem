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
public class Test_GridViewData {

    @Test
    public void test_GridViewData(){
        GridViewData gridViewData=new GridViewData(1,"1","1","1");
        assertEquals(1,gridViewData.getResourceId());
        assertEquals("1",gridViewData.getLocation());
        assertEquals("1",gridViewData.getDescription());
        assertEquals("1",gridViewData.getName());
    }

}
