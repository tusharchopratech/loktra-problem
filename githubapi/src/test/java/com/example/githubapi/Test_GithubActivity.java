package com.example.githubapi;

/**
 * Created by tc on 7/7/16.
 */

import android.content.Intent;

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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21,manifest = "src/main/AndroidManifest.xml", packageName = "com.example.githubapi")
public class Test_GithubActivity {


    GithubActivity githubActivity;
    @Before
    public void setup(){
        githubActivity= Robolectric.setupActivity(GithubActivity.class);
    }

    @Test
    public void checkNulls(){
        assertNotNull(githubActivity.buttonGithub);
        assertNotNull(githubActivity.listViewGithubData);
    }

    @Test
    public void test_performClick(){
        githubActivity.buttonGithub.performClick();
        assertNotEquals(0,githubActivity.bundleArrayList.size());
    }
}
