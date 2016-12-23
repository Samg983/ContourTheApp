package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Adapters.ItemClickListener;
import swarm_app_3.ehb.com.contourtheapp.Adapters.SectionedExpandableLayoutHelper;
import swarm_app_3.ehb.com.contourtheapp.Model.GalleryCheckpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.GalleryPhoto;
import swarm_app_3.ehb.com.contourtheapp.Model.OpenDialogGalleryPhoto;
import swarm_app_3.ehb.com.contourtheapp.R;

public class GalleryActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView mRecyclerView;

    ImageView galleryPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //setting the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        SectionedExpandableLayoutHelper sectionedExpandableLayoutHelper = new SectionedExpandableLayoutHelper(this,
                mRecyclerView, this, 3);

        //random data
        ArrayList<GalleryPhoto> arrayList = new ArrayList<>();
        arrayList.add(new GalleryPhoto(R.drawable.alps1, 0));
        arrayList.add(new GalleryPhoto(R.drawable.alps2, 1));
        arrayList.add(new GalleryPhoto(R.drawable.alps3, 2));
        arrayList.add(new GalleryPhoto(R.drawable.alps4, 3));
        sectionedExpandableLayoutHelper.addSection("Checkpoint 1", arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new GalleryPhoto(R.drawable.alps5, 0));
        arrayList.add(new GalleryPhoto(R.drawable.alps4, 1));
        arrayList.add(new GalleryPhoto(R.drawable.alps3, 2));
        arrayList.add(new GalleryPhoto(R.drawable.alps2, 3));
        arrayList.add(new GalleryPhoto(R.drawable.alps1, 4));
        arrayList.add(new GalleryPhoto(R.drawable.alps4, 5));
        sectionedExpandableLayoutHelper.addSection("Checkpoint 2", arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new GalleryPhoto(R.drawable.alps5, 0));
        arrayList.add(new GalleryPhoto(R.drawable.alps2, 1));
        arrayList.add(new GalleryPhoto(R.drawable.alps1, 2));
        arrayList.add(new GalleryPhoto(R.drawable.alps1, 3));
        arrayList.add(new GalleryPhoto(R.drawable.alps3, 4));
        sectionedExpandableLayoutHelper.addSection("Checkpoint 3", arrayList);

        sectionedExpandableLayoutHelper.notifyDataSetChanged();


        //checking if adding single item works!!!!!!!!!!!!!!!!!!!!!
        //sectionedExpandableLayoutHelper.addItem("Ice cream", new GalleryPhoto("Tutti frutti",5));
        //sectionedExpandableLayoutHelper.notifyDataSetChanged();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(GalleryPhoto item) {


//Popout van gallery werkt voorlopig niet (imageview blijft op 0 staan?). Dus ik heb TOAST laten staan.

           /* OpenDialogGalleryPhoto dialogPhoto = new OpenDialogGalleryPhoto(this, item.getImgGallery());

            dialogPhoto.show();*/


        Toast.makeText(this, "GalleryPhoto: " + item.getImgGallery() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked(GalleryCheckpoint section) {

        Toast.makeText(this, "GalleryCheckpoint: " + section.getName() + " clicked", Toast.LENGTH_SHORT).show();

    }
}
