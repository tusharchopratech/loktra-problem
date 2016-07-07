package com.example.tc.loktra;

/**
 * Created by tc on 7/7/16.
 */
import android.content.Intent;

import com.example.flickrflipper.FlickrFlipper;
import com.example.githubapi.GithubActivity;

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
@Config(constants = BuildConfig.class, sdk = 21,manifest = "src/main/AndroidManifest.xml", packageName = "com.example.tc.loktra")
public class Test_MainActivity {

    MainActivity mainActivity;

    @Before
    public void setup(){
        mainActivity= Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void checkNulls(){
        assertNotNull(mainActivity.buttonFlickrFlipper);
        assertNotNull(mainActivity.buttonGithubApi);
    }

    @Test
    public void test_performClicks(){

        mainActivity.buttonFlickrFlipper.performClick();
        Intent expectedIntent=new Intent(mainActivity, FlickrFlipper.class);
        assertEquals(expectedIntent,shadowOf(mainActivity).getNextStartedActivity());

        mainActivity.buttonGithubApi.performClick();
        expectedIntent=new Intent(mainActivity, GithubActivity.class);
        assertEquals(expectedIntent,shadowOf(mainActivity).getNextStartedActivity());

    }
}
