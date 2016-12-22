package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register2Personal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_personal);

        TextView gender = (TextView) findViewById(R.id.gender);
        TextView height = (TextView) findViewById(R.id.height);
        TextView eyecolor = (TextView) findViewById(R.id.eyecolor);
        TextView haircolor = (TextView) findViewById(R.id.haircolor);
        TextView titel = (TextView) findViewById(R.id.PersonalTitle);
        TextView next = (TextView) findViewById(R.id.lblNext);
        TextView prev = (TextView) findViewById(R.id.lblPrev);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        titel.setTypeface(customFonts);
        gender.setTypeface(customFonts);
        height.setTypeface(customFonts);
        eyecolor.setTypeface(customFonts);
        haircolor.setTypeface(customFonts);
        next.setTypeface(customFonts);
        prev.setTypeface(customFonts);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Male", "Female", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{"Brown", "Blue", "Grey", "Green", "Other"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = (Spinner)findViewById(R.id.spinner3);
        String[] items3 = new String[]{"Brown", "Blonde", "Black", "Ginger", "White", "Grey", "Other"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);
    }

    public void goToRegi1 (View view) {
        Intent toRegi1 = new Intent(this, Register1Basic.class);
        startActivity(toRegi1);
    }

    public void goToRegi3 (View view) {
        Intent toRegi3 = new Intent(this, Register3Weird.class);
        startActivity(toRegi3);
    }
}
