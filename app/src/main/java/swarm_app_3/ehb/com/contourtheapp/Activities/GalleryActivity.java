package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import android.widget.Toast;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Adapters.ItemClickListener;
import swarm_app_3.ehb.com.contourtheapp.Adapters.SectionedExpandableLayoutHelper;
import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.Photo;
import swarm_app_3.ehb.com.contourtheapp.R;

public class GalleryActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //recyclerview wordt gebruikt om de view op te bouwen. Dit is nodig om een gridlayout in een expandable list layout te laten werken.
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        SectionedExpandableLayoutHelper sectionedExpandableLayoutHelper = new SectionedExpandableLayoutHelper(this,
                mRecyclerView, this, 3);

        //static data invoegen (aangezien foto's nog moeilijk op te halen zijn van de database houden we deze momenteel hardcoded)
        ArrayList<Photo> arrayList = new ArrayList<>();
        arrayList.add(new Photo(0, R.drawable.alps1, 0));
        arrayList.add(new Photo(1, R.drawable.alps2, 0));
        arrayList.add(new Photo(2, R.drawable.alps3, 0));
        arrayList.add(new Photo(3, R.drawable.alps4, 0));
        sectionedExpandableLayoutHelper.addSection(1, arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new Photo(0, R.drawable.alps5, 1));
        arrayList.add(new Photo(1, R.drawable.alps4, 1));
        arrayList.add(new Photo(2, R.drawable.alps3, 1));
        arrayList.add(new Photo(3, R.drawable.alps2, 1));
        arrayList.add(new Photo(4, R.drawable.alps1, 1));
        arrayList.add(new Photo(5, R.drawable.alps4, 1));
        sectionedExpandableLayoutHelper.addSection(2, arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new Photo(0, R.drawable.alps5, 2));
        arrayList.add(new Photo(1, R.drawable.alps2, 2));
        arrayList.add(new Photo(2, R.drawable.alps1, 2));
        arrayList.add(new Photo(3, R.drawable.alps1, 2));
        arrayList.add(new Photo(4, R.drawable.alps3, 2));
        sectionedExpandableLayoutHelper.addSection(3, arrayList);

        sectionedExpandableLayoutHelper.notifyDataSetChanged();

        CreateMenu menu = new CreateMenu(GalleryActivity.this, getApplicationContext());
        menu.showMenu();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(Photo item) {

        //Popout van gallery werkt voorlopig niet (imageview blijft op 0 staan?). Dus ik heb TOAST laten staan.


        Toast.makeText(this, "Photo: " + item.getSourcePhoto() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked(Checkpoint section) {

        Toast.makeText(this, "Checkpoint: " + section.getCheckpointId() + " clicked", Toast.LENGTH_SHORT).show();

    }
}
