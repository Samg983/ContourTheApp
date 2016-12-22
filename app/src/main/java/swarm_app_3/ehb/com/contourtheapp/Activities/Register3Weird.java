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

public class Register3Weird extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3_weird);

        TextView title = (TextView) findViewById(R.id.finishtitle);
        TextView noselength = (TextView) findViewById(R.id.noselength);
        TextView dimples = (TextView) findViewById(R.id.dimples);
        TextView numberoffingers = (TextView) findViewById(R.id.numberoffingers);
        TextView numberoftoes = (TextView) findViewById(R.id.numberoftoes);
        TextView shoesize = (TextView) findViewById(R.id.shoesize);
        TextView next = (TextView) findViewById(R.id.lblNext);
        TextView prev = (TextView) findViewById(R.id.lblPrev);
        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        title.setTypeface(customFonts);
        noselength.setTypeface(customFonts);
        dimples.setTypeface(customFonts);
        numberoffingers.setTypeface(customFonts);
        numberoftoes.setTypeface(customFonts);
        shoesize.setTypeface(customFonts);
        next.setTypeface(customFonts);
        prev.setTypeface(customFonts);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Yes", "No"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{"4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = (Spinner)findViewById(R.id.spinner3);
        String[] items3 = new String[]{"4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);

        Spinner dropdown4 = (Spinner)findViewById(R.id.spinner4);
        String[] items4 = new String[]{"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items4);
        dropdown4.setAdapter(adapter4);
    }

    public void goToRegi2 (View view) {
        Intent toRegi2 = new Intent(this, Register2Personal.class);
        startActivity(toRegi2);
    }

    public void goToRegi4 (View view) {
        Intent toRegi4 = new Intent(this, Register4AlmostFinished.class);
        startActivity(toRegi4);
    }
}
