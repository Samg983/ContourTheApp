package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk.KenmerkGetAll;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView contourtitel = (TextView) findViewById(R.id.titel);
        TextView ctitel = (TextView) findViewById(R.id.ctitel);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "Raleway-Thin.ttf");
        contourtitel.setTypeface(customFonts);
        ctitel.setTypeface(customFonts);

        Thread SplashThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1500);
                    Intent splashToMain = new Intent(getApplicationContext(), SwarmActivity.class);
                    startActivity(splashToMain);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        SplashThread.start();

        KenmerkGetAll kenmerkGetAll = new KenmerkGetAll(new Response.Listener<ArrayList<Kenmerk>>() {
            @Override
            public void onResponse(ArrayList<Kenmerk> response) {
                Log.d("Geslaagd?", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("fail?", error.toString());
            }
        });

        Webservice.getRequestQueue().add(kenmerkGetAll);
    }
}
