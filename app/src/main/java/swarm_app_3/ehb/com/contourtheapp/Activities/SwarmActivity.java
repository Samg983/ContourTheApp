package swarm_app_3.ehb.com.contourtheapp.Activities;


import android.content.Intent;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Manifest;
import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.OpenDialogSwarmInfo;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving.InschrijvingGetAll;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk.KenmerkGetAll;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk.KenmerkGetById;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk.KenmerkVoegToe;

import static swarm_app_3.ehb.com.contourtheapp.R.id.map;


public class SwarmActivity extends FragmentActivity implements OnMapReadyCallback {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private FloatingActionButton.LayoutParams actionButtonParams;
    private FloatingActionButton.LayoutParams subActionButtonParams;
    private int radius;
    private GoogleMap mMap;
    private static final String TAG = SwarmActivity.class.getSimpleName();

    private boolean alreadySubscribed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        TextView next = (TextView) findViewById(R.id.lblNext);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "Raleway-Thin.ttf");
        next.setTypeface(customFonts);

        Button subscribeButton = (Button) findViewById(R.id.btnSubscribe1);


        if(alreadySubscribed){
            subscribeButton.setVisibility(View.INVISIBLE);
            next.setVisibility(View.INVISIBLE);
            createMenu();
        } else {
            subscribeButton.setVisibility(View.VISIBLE);
        }




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.getUiSettings().setAllGesturesEnabled(false);
        //Plaatsen die getekend worden op map
        LatLng Gent = new LatLng(51.0535, 3.7304);
        LatLng Strasbourg = new LatLng(48.58392,7.74553);
        LatLng Paris = new LatLng(48.864716,2.349014);
        LatLng Brussel = new LatLng(50.850340, 4.35171);
        LatLng Namen = new LatLng(50.467388, 4.871985);
        LatLng Dusseldorf = new LatLng(51.227741, 6.773456);
        LatLng Keulen = new LatLng(50.937531, 6.960279);
        LatLng Amsterdam = new LatLng(52.370216, 4.895168);
        LatLng Maastricht = new LatLng(50.851368, 5.690973);
        LatLng Spa = new LatLng(50.491996, 5.864639);
        LatLng Stuttgard = new LatLng(48.774682, 9.181480);
        LatLng Nancy = new LatLng(48.690815, 6.184959);
        LatLng Genève = new LatLng(46.204242, 6.143203);
        LatLng Milaan = new LatLng(45.465351, 9.186115);
        LatLng Luik = new LatLng(50.632199, 5.580368);
        LatLng Halle = new LatLng(50.737452, 4.232311);
        LatLng Kortrijk = new LatLng(50.816226, 3.260193);
        LatLng Turnhout = new LatLng(51.318114, 4.949341);
        LatLng Antwerpen = new LatLng(51.206399, 4.413757);
        LatLng Tilburg = new LatLng(51.557196, 5.090790);

        //Tekenen van Userlocations
        WriteLoc(Paris,"Paris");
        WriteLoc(Gent,"Gent");
        WriteLoc(Brussel,"Brussel");
        WriteLoc(Namen,"Namur");
        WriteLoc(Dusseldorf,"Dusseldorf");
        WriteLoc(Keulen,"Cologne");
        WriteLoc(Amsterdam,"Amsterdam");
        WriteLoc(Maastricht,"Maastricht");
        WriteLoc(Spa,"Spa");
        WriteLoc(Stuttgard,"Stuttgard");
        WriteLoc(Nancy,"Nancy");
        WriteLoc(Genève,"Genève");
        WriteLoc(Milaan,"Milaan");
        WriteLoc(Luik,"Luik");
        WriteLoc(Halle,"Halle");
        WriteLoc(Kortrijk,"Kortrijk");
        WriteLoc(Antwerpen,"Antwerpen");
        WriteLoc(Tilburg,"Tilburg");
        WriteLoc(Turnhout,"Turnhout");

        //Plaats van wandeling
        LatLng Biella = new LatLng(45.5630400, 8.0579600);
        String BiellaS = "Biella";

        //Tekenen wandelingplaats
        mMap.addMarker(new MarkerOptions()
                        .position(Biella)
                        .anchor(0.5f,0.5f)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.biella_place))
                        .title(BiellaS));

        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(100.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Strasbourg));

        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {}
    }

    public void openPopupSwarm(View view) {
        OpenDialogSwarmInfo dialogSwarm = new OpenDialogSwarmInfo(this);
        dialogSwarm.show();
    }

    public void WriteLoc(LatLng a, String b) {
        LatLng Biella = new LatLng(45.5630400, 8.0579600);
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .zIndex(10)
                .add(a, Biella)
                .geodesic(true)
                .width(5)
                .color(Color.argb(255,66,160,71)));
        mMap.addMarker(new MarkerOptions()
                .zIndex(20)
                .position(a)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.swarm_place))
                .anchor(0.5f,0.5f)
                .title(b));
    }

    public void goToRegisterFromSwarm(View view) {
        Intent toRegisterFromSwarm = new Intent(this, Register1Basic.class);
        startActivity(toRegisterFromSwarm);
    }

    public void goToHomeFromSwarm(View view) {
        Intent toHomeFromSwarm = new Intent(this, HomeScreen.class);
        startActivity(toHomeFromSwarm);
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
        icon.setImageDrawable(getDrawable(R.drawable.circle_menu_green_with_white_border));
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .setPosition(5)
                .setBackgroundDrawable(R.drawable.shadow_circular_button)
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
