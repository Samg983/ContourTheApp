package swarm_app_3.ehb.com.contourtheapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import swarm_app_3.ehb.com.contourtheapp.Model.Blog;
import swarm_app_3.ehb.com.contourtheapp.R;

/**
 * Created by Bram Schrooyen on 20/12/2016.
 */

public class BlogArrayAdapter extends ArrayAdapter<Blog> {
        private Context mijnContext;
        private List<Blog> myBlogList;
        public BlogArrayAdapter(Context context, List<Blog> objects) {
            super(context, -1, objects);
            this.myBlogList = objects;
            this.mijnContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mijnLayoutInflater = (LayoutInflater)mijnContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mijnListViewItemView = mijnLayoutInflater.inflate(R.layout.listitemview_blog, parent, false);
            ImageView imgAfbeelding = (ImageView)mijnListViewItemView.findViewById(R.id.imgAfbeelding);
            TextView txtTitle = (TextView)mijnListViewItemView.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView)mijnListViewItemView.findViewById(R.id.txtDescription);
            TextView txtLocation = (TextView)mijnListViewItemView.findViewById(R.id.txtLocation);
            TextView txtDate = (TextView)mijnListViewItemView.findViewById(R.id.txtDate);

           /* Blog weerTeGevenWork = myBlogList.get(position);
            txtTitle.setText(weerTeGevenWork.getTitle());
            txtArtist.setText(weerTeGevenWork.getArtist());
            imgAfbeelding.setImageResource(weerTeGevenWork.getImageResource());*/
            return mijnListViewItemView;
        //}
    }

}
