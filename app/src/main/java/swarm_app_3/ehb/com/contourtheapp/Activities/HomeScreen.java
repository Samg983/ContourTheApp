package swarm_app_3.ehb.com.contourtheapp.Activities;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import swarm_app_3.ehb.com.contourtheapp.R;

public class HomeScreen extends AppCompatActivity {
    FloatingActionButton.LayoutParams actionButtonParams;
    FloatingActionButton.LayoutParams subActionButtonParams;
    int radius;
    VideoView videov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView contourtitel = (TextView) findViewById(R.id.titel);
        TextView ctitel = (TextView) findViewById(R.id.ctitel);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "Raleway-Thin.ttf");
        contourtitel.setTypeface(customFonts);
        ctitel.setTypeface(customFonts);
        videov = (VideoView) findViewById(R.id.VidV);
        videoplay(videov);
        createMenu();
        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                videov.start();

            }
        });

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
                Intent toMaps = new Intent(HomeScreen.this, SwarmActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        blogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(HomeScreen.this, SplashScreen.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        trackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(HomeScreen.this, HomeScreen.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(HomeScreen.this, SwarmActivity.class);
                startActivity(toMaps);
                actionMenu.close(true);
            }
        });

    }

    public void videoplay(View v) {
        String path = "android.resource://" + getPackageName() + "/" + R.raw.lines;
        Uri uri = Uri.parse(path);
        videov.setVideoURI(uri);
        videov.start();
    }

    @Override
    protected void onResume() {
        super.onResume();


        videov.start();


    }
}
