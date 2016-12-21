package swarm_app_3.ehb.com.contourtheapp.Activities;


import android.content.Intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import swarm_app_3.ehb.com.contourtheapp.Model.OpenDialog;
import swarm_app_3.ehb.com.contourtheapp.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String TAG = MapsActivity.class.getSimpleName();
    private LatLngBounds EUROPE = new LatLngBounds(
            new LatLng(41.390205, 2.154007), new LatLng(55.676098, 12.568337));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        TextView next = (TextView) findViewById(R.id.lblNext);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "Raleway-Thin.ttf");
        next.setTypeface(customFonts);
    }


    /**
     * Manipulates the map once available. Please let this work
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Gent = new LatLng(51.0535, 3.7304);
        LatLng Biella = new LatLng(45.5630400, 8.0579600);
        LatLng België = new LatLng(50.503887,4.4699359999999615);

        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(Gent, Biella)
                .width(5)
                .color(Color.GREEN));

        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(42.0f);

       mMap.moveCamera(CameraUpdateFactory.newLatLng(België));
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {

        }
    }

    public void openPopup(View view) {
        OpenDialog dialog = new OpenDialog(this);
        dialog.show();
    }


    public void goToRegisterFromSwarm(View view) {
        Intent toRegisterFromSwarm = new Intent(this, Register1Basic.class);
        startActivity(toRegisterFromSwarm);
    }

    public void goToHomeFromSwarm(View view) {
        Intent toHomeFromSwarm = new Intent(this, HomeScreen.class);
        startActivity(toHomeFromSwarm);
    }
}
