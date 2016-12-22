package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register1Basic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1_basic);
        TextView titel = (TextView) findViewById(R.id.titel);
        TextView name = (TextView) findViewById(R.id.noselength);
        TextView dateofbirth = (TextView) findViewById(R.id.dateofbirth);
        TextView city = (TextView) findViewById(R.id.city);
        TextView next = (TextView) findViewById(R.id.lblNext);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        titel.setTypeface(customFonts);
        name.setTypeface(customFonts);
        dateofbirth.setTypeface(customFonts);
        city.setTypeface(customFonts);
        next.setTypeface(customFonts);
    }

    public void goToRegi2 (View view) {
        Intent toRegi2 = new Intent(this, Register2Personal.class);
        startActivity(toRegi2);
    }
}
