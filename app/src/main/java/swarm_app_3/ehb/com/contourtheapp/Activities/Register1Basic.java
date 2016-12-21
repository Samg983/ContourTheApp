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

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13", "14", "15", "16","17", "18", "19", "20", "21", "22", "23", "24","25", "26", "27", "28", "29", "30", "31", "32","33", "34", "35", "36", "37", "38", "39", "40","41", "42", "43", "44", "45", "46", "47", "48","49", "50", "51", "52", "53", "54", "55", "56","57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72","73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83","84", "85", "86", "87", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void goToRegiTwee(View view) {
        Intent toRegiTwee = new Intent(this, Register2Personal.class);
        startActivity(toRegiTwee);
    }
}
