package swarm_app_3.ehb.com.contourtheapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton.LayoutParams actionButtonParams;
    FloatingActionButton.LayoutParams subActionButtonParams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMenu();
    }

    public void goToSplash(View view) {
        Intent toSplash = new Intent(this, SplashScreen.class);
        startActivity(toSplash);
    }

    public void openMaps(View view) {
        Intent toMaps = new Intent(this, MapsActivity.class);
        startActivity(toMaps);
    }

    public void openHome(View view) {
        Intent toHome = new Intent(this, HomeScreen.class);
        startActivity(toHome);
    }


    public void createMenu(){

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                actionButtonParams =  new FloatingActionButton.LayoutParams(300,300);
                subActionButtonParams = new FloatingActionButton.LayoutParams(450,225);
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                actionButtonParams =  new FloatingActionButton.LayoutParams(150,150);
                subActionButtonParams = new FloatingActionButton.LayoutParams(225,112);
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                actionButtonParams =  new FloatingActionButton.LayoutParams(100,100);
                subActionButtonParams = new FloatingActionButton.LayoutParams(200,100);
                break;
            default:
                actionButtonParams =  new FloatingActionButton.LayoutParams(150,150);
                subActionButtonParams = new FloatingActionButton.LayoutParams(225,112);
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
                .setRadius(350)
                // ...
                .attachTo(actionButton)
                .build();

        swarmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent toMaps = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        blogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent toMaps = new Intent(MainActivity.this, SplashScreen.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        trackerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent toMaps = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent toMaps = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

    }

}
