package swarm_app_3.ehb.com.contourtheapp.Activities;


import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;

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
        TextView contourtitel = (TextView) findViewById(R.id.lblTitel);
        TextView ctitel = (TextView) findViewById(R.id.ctitel);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "Raleway-Thin.ttf");
        contourtitel.setTypeface(customFonts);
        ctitel.setTypeface(customFonts);
        videov = (VideoView) findViewById(R.id.VidV);
        videoplay(videov);

        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                videov.start();

            }
        });


        CreateMenu menu = new CreateMenu(HomeScreen.this, getApplicationContext());
        menu.showMenu();

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
