package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import swarm_app_3.ehb.com.contourtheapp.R;

public class MainActivity extends AppCompatActivity {
    private TelephonyManager telephonyManager;
    private FloatingActionButton.LayoutParams actionButtonParams;
    private FloatingActionButton.LayoutParams subActionButtonParams;
    private int radius;
    private static final int MY_PERMISSIONS_REQUEST_TELEPHONESTATE = 99;

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

    public void showImeiNumber(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {

            String IMEI_Number_Holder;
            telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
            IMEI_Number_Holder = telephonyManager.getDeviceId();
            Toast.makeText(this, "Imei: " + IMEI_Number_Holder, Toast.LENGTH_SHORT).show();

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_TELEPHONESTATE);
        }
    }


}
