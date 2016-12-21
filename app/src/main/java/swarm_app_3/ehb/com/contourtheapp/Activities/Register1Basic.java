package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register1Basic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1_basic);
        TextView titel = (TextView) findViewById(R.id.titel);
        TextView name = (TextView) findViewById(R.id.name);
        TextView age = (TextView) findViewById(R.id.age);
        TextView city = (TextView) findViewById(R.id.city);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        titel.setTypeface(customFonts);
        name.setTypeface(customFonts);
        age.setTypeface(customFonts);
        city.setTypeface(customFonts);

    }
}
