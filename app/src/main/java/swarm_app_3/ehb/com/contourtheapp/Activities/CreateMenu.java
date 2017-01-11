package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import swarm_app_3.ehb.com.contourtheapp.R;

/**
 * Created by SamGoeman on 10/01/2017.
 * Menu by Bram Schrooyen
 */


/*
    Klasse wordt in bijna elke activity opgeroepen, en daarom als aparte klasse aangemaakt om zo min mogelijk dubbele code te hebben.
    De FloatingActionButton wordt aangemaakt via een github-library (compiled in build.gradle) -> https://github.com/oguzbilgener/CircularFloatingActionMenu
 */

public class CreateMenu {
    private FloatingActionButton.LayoutParams actionButtonParams;
    private FloatingActionButton.LayoutParams subActionButtonParams;
    private int radius;
    private Activity activity;
    private Context context;

    public CreateMenu(final Activity activity, final Context context) {
        this.activity = activity;
        this.context = context;
    }

    public void showMenu() {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        //kijken naar de DPI-density van het gebruikte apparaat. Radius van de menuknop groter of kleiner maken naargelang de density.
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

        //Image voor de menu-knop zetten -> Groene bol met dunne witte rand
        ImageView icon = new ImageView(activity); // Create an icon
        icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.circle_menu_green_with_white_border));
        FloatingActionButton actionButton = new FloatingActionButton.Builder(activity)
                .setContentView(icon)
                .setPosition(5)
                .setBackgroundDrawable(R.drawable.shadow_circular_button)
                .setLayoutParams(actionButtonParams)
                .build();


        //Builder voor de submenu-knoppen
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(activity);

        // herhalen voor elke submenu-knop
        ImageView itemIcon = new ImageView(activity);
        itemIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.menu_item1));
        SubActionButton swarmButton = itemBuilder.setContentView(itemIcon).setLayoutParams(subActionButtonParams).setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.transparent)).build();

        ImageView itemIcon2 = new ImageView(activity);
        itemIcon2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.menu_item2));
        SubActionButton blogButton = itemBuilder.setContentView(itemIcon2).build();

        //transparante knop zonder onClickListener. Geeft meer plaats tussen de andere knoppen om zo ons design zo goed mogelijk te kunnen benaderen.
        ImageView itemIcon3 = new ImageView(activity);
        itemIcon3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.transparent));
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();

        ImageView itemIcon4 = new ImageView(activity);
        itemIcon4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.menu_item3));
        SubActionButton trackerButton = itemBuilder.setContentView(itemIcon4).build();

        ImageView itemIcon5 = new ImageView(activity);
        itemIcon5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.menu_item4));
        SubActionButton galleryButton = itemBuilder.setContentView(itemIcon5).build();

        //Builder voor volledige menu
        final FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(activity)
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


        //onClickListeners aan elke subitem-knop hangen.
        swarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(activity, SwarmActivity.class);
                activity.startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        blogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBlogs = new Intent(activity, BlogListActivity.class);
                activity.startActivity(toBlogs);
                actionMenu.close(true);
            }
        });

        trackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaps = new Intent(activity, TrackerActivity.class);
                activity.startActivity(toMaps);
                actionMenu.close(true);
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toGallery = new Intent(activity, GalleryActivity.class);
                activity.startActivity(toGallery);
                actionMenu.close(true);
            }
        });

    }
}

