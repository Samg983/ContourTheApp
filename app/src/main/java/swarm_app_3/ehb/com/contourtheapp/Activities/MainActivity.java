package swarm_app_3.ehb.com.contourtheapp.Activities;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import swarm_app_3.ehb.com.contourtheapp.R;


//Niet zichtbaar in de app. Je kan HomeScreen zien als de MainActivity van deze applicatie.
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void goToSplash(View view) {
        Intent toSplash = new Intent(this, SplashScreen.class);
        startActivity(toSplash);
    }

    public void goToRegi(View view) {
        Intent toRegi = new Intent(this, Register1Basic.class);
        startActivity(toRegi);
    }

    public void openMaps(View view) {
        Intent toMaps = new Intent(this, SwarmActivity.class);
        startActivity(toMaps);

    }

    public void openHome(View view) {
        Intent toHome = new Intent(this, HomeScreen.class);
        startActivity(toHome);
    }

    public void goToTracker(View view) {
        Intent toTracker = new Intent(this, TrackerActivity.class);
        startActivity(toTracker);
    }


}
