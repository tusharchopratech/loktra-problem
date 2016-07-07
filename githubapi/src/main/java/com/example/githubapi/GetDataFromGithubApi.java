package com.example.githubapi;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by tc on 7/5/16.
 */

public class GetDataFromGithubApi {

    public static final String BASE_URL="https://api.github.com/";

    public GetDataFromGithubApi(){

    }

    public ArrayList<Bundle> getData(){

        ArrayList<Bundle> bundleArrayList=new ArrayList<>();

         Retrofit adapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                .build();
        RxvChatInterface api = adapter.create(RxvChatInterface.class);
        Call<List<GithubResponse>> call = api.listRepos("zuhao","rails");
        try {
            Response<List<GithubResponse>> response = call.execute();
            if (response != null && response.code() == 200) {

                List<GithubResponse> githubResponseList=response.body();
                for(int i=0;i<githubResponseList.size();i++) {
                    String name=githubResponseList.get(i).getCommit().getAuthor().getName();
                    String message=githubResponseList.get(i).getCommit().getMessage();
                    String date=githubResponseList.get(i).getCommit().getAuthor().getDate();

                    Bundle bundle=new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("message",message);
                    bundle.putString("date",date);
                    bundleArrayList.add(bundle);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return bundleArrayList;
    }


    class GithubResponse {
        private Commit commit;
        public Commit getCommit ()
        {
            return commit;
        }


        public class Commit {
            private String comment_count;

            private String message;

            public String getMessage() {
                return message;
            }

            private Author author;

            public Author getAuthor() {
                return author;
            }

            private String url;

            public class Author {
                private String email;

                public String getName() {
                    return name;
                }

                public String getDate() {
                    return date;
                }

                private String name;

                private String date;
            }
        }
    }


    public interface RxvChatInterface {
        @GET("repos/{user}/{repo}/commits")
        Call<List<GithubResponse>> listRepos(@Path("user") String user, @Path("repo") String repo);
    }


}
