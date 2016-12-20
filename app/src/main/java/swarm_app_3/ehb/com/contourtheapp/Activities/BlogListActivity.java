package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.R;

public class BlogListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);

        updateBlogListView();
    }


    private void updateBlogListView(){
        //ArrayList<Blog> workList = WorkDao.getWorks();

        //WorkArrayAdapter myWorkArrayAdapter = new WorkArrayAdapter(this, workList);
        ListView lstBlogs = (ListView)findViewById(R.id.lstBlogs);
        //lstBlogs.setAdapter(myBlogArrayAdapter);

        /*lstWorks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Work selectedWork = (Work)parent.getItemAtPosition(position);
                Log.d("Selected Work", Integer.toString(selectedWork.getWorkId()));

                Intent mijnIntent = new Intent(WorkListActivity.this, WorkActivity.class);
                mijnIntent.putExtra("workid", selectedWork.getWorkId());
                startActivity(mijnIntent);
            }
        });*/

    }
}
