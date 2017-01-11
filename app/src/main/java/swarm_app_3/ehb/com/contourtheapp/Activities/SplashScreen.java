package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.Model.StaticIds;
import swarm_app_3.ehb.com.contourtheapp.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView contourtitel = (TextView) findViewById(R.id.lblTitel);
        TextView ctitel = (TextView) findViewById(R.id.ctitel);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "Raleway-Thin.ttf");
        contourtitel.setTypeface(customFonts);
        ctitel.setTypeface(customFonts);

        Thread SplashThread = new Thread() {
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


    }
}
