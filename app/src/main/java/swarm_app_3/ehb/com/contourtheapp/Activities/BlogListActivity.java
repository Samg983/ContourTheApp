package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Adapters.BlogArrayAdapter;
import swarm_app_3.ehb.com.contourtheapp.Model.Blogpost;
import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.blogpost.BlogpostGetAll;
import swarm_app_3.ehb.com.contourtheapp.Webservice.blogpost.BlogpostWebservice;

public class BlogListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);

        BlogpostGetAll mijnBlogpostGetAll = new BlogpostGetAll(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Request geslaagd?", response);

                Gson gson = new Gson();
                ArrayList<Blogpost> blogList = gson.fromJson(response, new TypeToken<ArrayList<Blogpost>>(){}.getType());

                for(Blogpost blogpost : blogList) {
                    Log.d("Request geslaagd?", blogpost.toString());
                }

                BlogArrayAdapter myBlogArrayAdapter = new BlogArrayAdapter(getApplicationContext(),blogList);

                updateBlogListView(myBlogArrayAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Request geslaagd?", "Noooooooooo");
            }
        });

        Webservice.getRequestQueue().add(mijnBlogpostGetAll);

    }


    private void updateBlogListView(BlogArrayAdapter blogArrayAdapter){

        ListView lstBlogs = (ListView)findViewById(R.id.lstBlogs);

        lstBlogs.setAdapter(blogArrayAdapter);

    }
}
