package swarm_app_3.ehb.com.contourtheapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import swarm_app_3.ehb.com.contourtheapp.Model.Blogpost;
import swarm_app_3.ehb.com.contourtheapp.R;

/**
 * Created by Bram Schrooyen on 20/12/2016.
 */

public class BlogArrayAdapter extends ArrayAdapter<Blogpost> {
        private Context mijnContext;
        private List<Blogpost> myBlogpostList;
        public BlogArrayAdapter(Context context, ArrayList<Blogpost> objects) {
            super(context, -1, objects);
            this.myBlogpostList = objects;
            this.mijnContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mijnLayoutInflater = (LayoutInflater)mijnContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mijnListViewItemView = mijnLayoutInflater.inflate(R.layout.listitemview_blog, parent, false);

            TextView txtTitle = (TextView)mijnListViewItemView.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView)mijnListViewItemView.findViewById(R.id.txtDescription);
            TextView txtLocation = (TextView)mijnListViewItemView.findViewById(R.id.txtLocation);
            TextView txtDate = (TextView)mijnListViewItemView.findViewById(R.id.txtDate);
            ImageView imgBlog = (ImageView)mijnListViewItemView.findViewById(R.id.imgBlog);

            Blogpost weerTeGevenBlog = myBlogpostList.get(position);
            txtTitle.setText(weerTeGevenBlog.getTitle());
            txtDescription.setText(weerTeGevenBlog.getContent());
            txtLocation.setText(weerTeGevenBlog.getPlace());
            txtDate.setText(weerTeGevenBlog.getDateBlog());
            imgBlog.setImageResource(R.drawable.alps1);

            return mijnListViewItemView;
        //}
    }

}
