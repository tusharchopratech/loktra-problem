package com.example.githubapi;

/**
 * Created by tc on 7/7/16.
 */

import android.content.Intent;
import android.os.Bundle;

import com.example.githubapi.GithubActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21,manifest = "src/main/AndroidManifest.xml", packageName = "com.example.githubapi")
public class Test_GetDataFromGithubApi {

    GetDataFromGithubApi getDataFromGithubApi;

    @Before
    public void setup(){
        getDataFromGithubApi=new GetDataFromGithubApi();
    }

    @Test
    public void test_getData(){

        assertNotNull(getDataFromGithubApi);
        ArrayList<Bundle> bundleArrayList= getDataFromGithubApi.getData();
        assertNotNull(bundleArrayList);

        assertNotEquals(0,bundleArrayList.size());

        for(int i=0;i<bundleArrayList.size();i++){
            Bundle bundle=bundleArrayList.get(i);
            assertNotNull(bundle.getString("name"));
            assertNotNull(bundle.getString("message"));
            assertNotNull(bundle.getString("date"));
        }

    }
}
