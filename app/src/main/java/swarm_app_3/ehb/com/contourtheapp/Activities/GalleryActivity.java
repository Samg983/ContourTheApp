package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Adapters.ItemClickListener;
import swarm_app_3.ehb.com.contourtheapp.Adapters.SectionedExpandableLayoutHelper;
import swarm_app_3.ehb.com.contourtheapp.Model.GalleryCheckpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.GalleryPhoto;
import swarm_app_3.ehb.com.contourtheapp.Model.OpenDialogGalleryPhoto;
import swarm_app_3.ehb.com.contourtheapp.R;

public class GalleryActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView mRecyclerView;

    private ImageView galleryPhoto;
    private FloatingActionButton.LayoutParams actionButtonParams;
    private FloatingActionButton.LayoutParams subActionButtonParams;
    private int radius;

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

        createMenu();

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

    public void createMenu() {

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        switch (metrics.densityDpi) {
            case DisplayMetrics.DENSITY_HIGH:
            case DisplayMetrics.DENSITY_XHIGH:
            case DisplayMetrics.DENSITY_XXHIGH:
            case DisplayMetrics.DENSITY_XXXHIGH:
                actionButtonParams = new FloatingActionButton.LayoutParams(300, 300);
                subActionButtonParams = new FloatingActionButton.LayoutParams(450, 225);
                radius = 350;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                actionButtonParams = new FloatingActionButton.LayoutParams(200, 200);
                subActionButtonParams = new FloatingActionButton.LayoutParams(250, 125);
                radius = 225;
                break;
            case DisplayMetrics.DENSITY_LOW:
                actionButtonParams = new FloatingActionButton.LayoutParams(100, 100);
                subActionButtonParams = new FloatingActionButton.LayoutParams(150, 75);
                radius = 125;
                break;
            default:
                actionButtonParams = new FloatingActionButton.LayoutParams(300, 300);
                subActionButtonParams = new FloatingActionButton.LayoutParams(450, 225);
                radius = 350;
        }

        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getDrawable(R.drawable.circle_menu_green));
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .setPosition(5)
                .setLayoutParams(actionButtonParams)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        // repeat many times:
        ImageView itemIcon = new ImageView(this);
        itemIcon.setImageDrawable(getDrawable(R.drawable.menu_item1));
        SubActionButton swarmButton = itemBuilder.setContentView(itemIcon).setLayoutParams(subActionButtonParams).setBackgroundDrawable(getDrawable(R.drawable.transparent)).build();

        ImageView itemIcon2 = new ImageView(this);
        itemIcon2.setImageDrawable(getDrawable(R.drawable.menu_item2));
        SubActionButton blogButton = itemBuilder.setContentView(itemIcon2).build();

        ImageView itemIcon3 = new ImageView(this);
        itemIcon3.setImageDrawable(getDrawable(R.drawable.transparent));
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();

        ImageView itemIcon4 = new ImageView(this);
        itemIcon4.setImageDrawable(getDrawable(R.drawable.menu_item3));
        SubActionButton trackerButton = itemBuilder.setContentView(itemIcon4).build();

        ImageView itemIcon5 = new ImageView(this);
        itemIcon5.setImageDrawable(getDrawable(R.drawable.menu_item4));
        SubActionButton galleryButton = itemBuilder.setContentView(itemIcon5).build();

        final FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(swarmButton)
                .addSubActionView(blogButton)
                .addSubActionView(button3)
                .addSubActionView(trackerButton)
                .addSubActionView(galleryButton)
                .setStartAngle(180)
                .setEndAngle(360)
                .setRadius(radius)
                // ...
                .attachTo(actionButton)
                .build();

        swarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(getApplicationContext(), SwarmActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        blogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(getApplicationContext(), BlogActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        trackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(getApplicationContext(), TrackerActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });
    }
}
