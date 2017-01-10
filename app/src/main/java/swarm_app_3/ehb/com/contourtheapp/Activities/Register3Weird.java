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
    private TextView lblToes, lblFingers, lblShoeSize, lblNoseLength, lblDimples, lblNextRegi3, lblPrevRegi3, lblTitleRegi3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3_weird);

        lblTitleRegi3 = (TextView) findViewById(R.id.lblTitleRegi3);
        lblToes = (TextView) findViewById(R.id.lblToes);
        lblFingers = (TextView) findViewById(R.id.lblFingers);
        lblShoeSize = (TextView) findViewById(R.id.lblShoeSize);
        lblNoseLength = (TextView) findViewById(R.id.lblNoseLength);
        lblDimples = (TextView) findViewById(R.id.lblDimples);
        lblNextRegi3 = (TextView) findViewById(R.id.lblNextRegi3);
        lblPrevRegi3 = (TextView) findViewById(R.id.lblPrevRegi3);

        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");

        lblTitleRegi3.setTypeface(customFonts);
        lblToes.setTypeface(customFonts);
        lblFingers.setTypeface(customFonts);
        lblShoeSize.setTypeface(customFonts);
        lblNoseLength.setTypeface(customFonts);
        lblDimples.setTypeface(customFonts);
        lblNextRegi3.setTypeface(customFonts);
        lblPrevRegi3.setTypeface(customFonts);


        Spinner spnNoseLength = (Spinner)findViewById(R.id.spnNoseLength);
        String[] noseLength = new String[]{"1", "2", "3","4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterNoseLength = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, noseLength);
        spnNoseLength.setAdapter(adapterNoseLength);

        Spinner spnDimples = (Spinner)findViewById(R.id.spnDimples);
        String[] dimples = new String[]{"Yes", "No"};
        ArrayAdapter<String> adapterDimples = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dimples);
        spnDimples.setAdapter(adapterDimples);

        Spinner spnFingers = (Spinner)findViewById(R.id.spnFingers);
        String[] fingers = new String[]{"4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterFingers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, fingers);
        spnFingers.setAdapter(adapterFingers);

        Spinner spnToes = (Spinner)findViewById(R.id.spnToes);
        String[] toes = new String[]{"4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterToes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, toes);
        spnToes.setAdapter(adapterToes);

        Spinner spnShoeSize = (Spinner)findViewById(R.id.spnShoeSize);
        String[] shoeSize = new String[]{"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
        ArrayAdapter<String> adapterShoeSize = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, shoeSize);
        spnShoeSize.setAdapter(adapterShoeSize);
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
