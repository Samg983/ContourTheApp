package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register4AlmostFinished extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4_almost_finished);
        TextView prev = (TextView) findViewById(R.id.lblPrev);
        TextView finish = (TextView) findViewById(R.id.lblfinish);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        prev.setTypeface(customFonts);
        finish.setTypeface(customFonts);
    }
    public void goToRegi3 (View view) {
        Intent toRegi3 = new Intent(this, Register3Weird.class);
        startActivity(toRegi3);
    }

    public void goToHome (View view) {
        Intent toHome = new Intent(this, HomeScreen.class);
        startActivity(toHome);
    }
}
