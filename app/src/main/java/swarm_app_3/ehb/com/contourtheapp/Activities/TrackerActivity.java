package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Model.OpenMessagesTracker;
import swarm_app_3.ehb.com.contourtheapp.Model.SubscribeTracker;
import swarm_app_3.ehb.com.contourtheapp.Model.Usercoordinaat;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat.UsercoordinaatGetAllByInschrijvingsId;
import swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat.UsercoordinaatVoegToe;

public class TrackerActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Marker mCurrLocationMarker;
    private LocationRequest mLocationRequest;
    private static final String TAG = TrackerActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private ArrayList<LatLng> points = new ArrayList<LatLng>();
    private int opgehaaldInschrijvingsId;
    private Polyline line;
    private static final long INTERVAL = 1000; //1 minute
    private static final long FASTEST_INTERVAL = 1000; // 1 minute
    private static final float SMALLEST_DISPLACEMENT = 0.05F; //quarter of a meter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        opgehaaldInschrijvingsId = preferences.getInt("inschrijvingsId", 0);

        //indien er nog geen inschrijving is dan dialog showen om de gebruiker te pushen zich in te schrijven
        if (opgehaaldInschrijvingsId == 0) {
            SubscribeTracker subscribeTracker = new SubscribeTracker(this);
            subscribeTracker.show();
        } else {
            //indien er wel een inschrijving is dan de usercoordinaten ophalen die ter beschikking staan in de database
            getAllUserCoordinaten();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //menu tonen
        CreateMenu menu = new CreateMenu(TrackerActivity.this, getApplicationContext());
        menu.showMenu();


    }

    private void getAllUserCoordinaten() {

        //nieuwe request sturen
        UsercoordinaatGetAllByInschrijvingsId usercoordinaatGetAllByInschrijvingsId = new UsercoordinaatGetAllByInschrijvingsId(opgehaaldInschrijvingsId, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //indien response dan de array die we ontvangen ophalen en omzetten naar een arraylist
                gSonToArray(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("succes insch", error.toString());
            }
        });

        Webservice.getRequestQueue().add(usercoordinaatGetAllByInschrijvingsId);
    }

    private void gSonToArray(String response) {
        //JSON-string omzetten naar ArrayList van Usercoordinaten-objecten
        Gson gson = new Gson();
        ArrayList<Usercoordinaat> usercoordinaatList = gson.fromJson(response, new TypeToken<ArrayList<Usercoordinaat>>() {
        }.getType());

        //voor elk coordinaat maken we een nieuwe LatLng, deze voegen we dan toe aan points om later onze lijn mee te tekenen.
        for (Usercoordinaat usercoordinaat : usercoordinaatList) {
            LatLng latLng = new LatLng(usercoordinaat.getLatitude(), usercoordinaat.getLongtitude());
            points.add(latLng);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            //mapstyle proberen te zetten
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style_json));
            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {

        }

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                //mMap.setMyLocationEnabled(true);

            }
        } else {
            buildGoogleApiClient();
            //mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        //interval zetten om de hoeveel tijd hij moet gegevens versturen.
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setSmallestDisplacement(SMALLEST_DISPLACEMENT);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(final Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        Toast.makeText(this, "location changed", Toast.LENGTH_SHORT).show();
        //get latLng from current location
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean alreadySubscribed = preferences.getBoolean("alreadySubscribed", false);

        //indie je ingeschreven bent worden de huidige coordinaten toegevoegd aan de database
        if(alreadySubscribed) {
            UsercoordinaatVoegToe usercoordinaatVoegToe = new UsercoordinaatVoegToe(new Usercoordinaat(0, location.getLatitude(), location.getLongitude(), "0", opgehaaldInschrijvingsId), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("Geslaagd coordinaat", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("failed coordinaat", error.toString());
                }
            });

            Webservice.getRequestQueue().add(usercoordinaatVoegToe);
            redrawLine();
        }

        /*stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();
        }*/
        updateCameraBearing(mMap, location, latLng);

    }

    private void updateCameraBearing(GoogleMap googleMap, Location location, LatLng latLng) {

       //map aanpassen aan uw positie
        if (googleMap == null) return;
        CameraPosition camPos = CameraPosition
                .builder(
                        googleMap.getCameraPosition() // current Camera
                )
                .target(latLng)
                .zoom(20)
                .tilt(0)
                .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));
        location.bearingTo(location);


    }

    private void redrawLine() {
        mMap.clear();  //clears all Markers and Polylines

        PolylineOptions options = new PolylineOptions().width(10).color(Color.argb(255, 66, 160, 71)).geodesic(true); //lijn om alle punten te tekenen

        //indien points waarden bevat, voegen we deze toe aan options. Daarna wordt options toegevoegd en zo een lijn getekend
        if (!points.isEmpty()) {
            for (int i = 0; i < points.size(); i++) {
                LatLng point = points.get(i);
                options.add(point);
            }

            //marker plaatsen op het laatste punt
            addMarker(points.get(points.size() - 1)); //add Marker in current position
            line = mMap.addPolyline(options);
        }//add Polyline
    }

    private void addMarker(LatLng last) {


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(last);
        markerOptions.flat(true);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow));

        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //indien op de marker geklikt wordt, opent een dialog
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.equals(mCurrLocationMarker)) {
                    OpenMessagesTracker messages = new OpenMessagesTracker(TrackerActivity.this);
                    messages.show();
                }
                return true;
            }
        });

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        //mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }

}