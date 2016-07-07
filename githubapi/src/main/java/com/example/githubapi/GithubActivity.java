package com.example.githubapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GithubActivity extends AppCompatActivity {

    Button buttonGithub;
    ListView listViewGithubData;
    ArrayList<Bundle> bundleArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        buttonGithub= (Button) findViewById(R.id.buttonGithubId);
        listViewGithubData=(ListView) findViewById(R.id.listViewGithubDataId);
        buttonGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GithubActivity.this,"Make sure internet is working ..",Toast.LENGTH_LONG).show();
                new Background().execute();
            }
        });


    }

    class Background extends AsyncTask<Void,Integer,Integer>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bundleArrayList=new ArrayList<>();
            progressDialog=new ProgressDialog(GithubActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Please Wait ...");
            progressDialog.show();
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            bundleArrayList=new GetDataFromGithubApi().getData();
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            if(progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            if(bundleArrayList.size()>0){
                renderListView(bundleArrayList);
            }
        }
    }

    private void renderListView(ArrayList<Bundle> bundleArrayList) {
        listViewGithubData.setAdapter(new ListViewAdapter(GithubActivity.this,R.layout.inflate_listview,bundleArrayList));
    }

    class ListViewAdapter extends ArrayAdapter<Bundle>{

        ArrayList<Bundle> bundleArrayList;
        Context context;
        int resourceId;

        public ListViewAdapter(Context context, int resource, ArrayList<Bundle> objects) {
            super(context, resource, objects);
            this.context=context;
            bundleArrayList=objects;
            resourceId=resource;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout linearLayout = (LinearLayout) inflater.inflate(resourceId, parent, false);

            TextView nameTextView=(TextView) linearLayout.findViewById(R.id.textViewAuthorName);
            TextView messageTextView=(TextView) linearLayout.findViewById(R.id.textViewMessage);
            TextView dateTextView=(TextView) linearLayout.findViewById(R.id.textViewDate);

            Bundle bundle=bundleArrayList.get(position);
            nameTextView.setText(bundle.getString("name"));
            messageTextView.setText("\nCommit Message :\n"+bundle.getString("message"));
            dateTextView.setText("\nCommit Date :\n"+bundle.getString("date"));

            return linearLayout;
        }
    }

}
