package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register2Personal extends AppCompatActivity {

    private TextView lblTitleRegi2, lblHeight, lblGender, lblEyeColor, lblHairColor, lblNextRegi2, lblPrevRegi2;
    private EditText txtHeight;
    private Spinner spnGender, spnEyeColor, spnHairColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_personal);

        lblTitleRegi2 = (TextView) findViewById(R.id.lblTitleRegi3);
        lblHeight = (TextView) findViewById(R.id.lblHeight);
        lblEyeColor = (TextView) findViewById(R.id.lblEyeColor);
        lblHairColor = (TextView) findViewById(R.id.lblHairColor);
        lblNextRegi2 = (TextView) findViewById(R.id.lblNextRegi1);
        lblPrevRegi2 = (TextView) findViewById(R.id.lblPrev);
        lblGender = (TextView) findViewById(R.id.lblGender);

        txtHeight = (EditText) findViewById(R.id.txtHeight);


        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        lblTitleRegi2.setTypeface(customFonts);
        lblHeight.setTypeface(customFonts);
        lblEyeColor.setTypeface(customFonts);
        lblHairColor.setTypeface(customFonts);
        lblNextRegi2.setTypeface(customFonts);
        lblPrevRegi2.setTypeface(customFonts);
        lblGender.setTypeface(customFonts);
        txtHeight.setTypeface(customFonts);


        spnGender = (Spinner) findViewById(R.id.spnGender);
        String[] items = new String[]{"Male", "Female", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spnGender.setAdapter(adapter);

        spnEyeColor = (Spinner) findViewById(R.id.spnEyeColor);
        String[] items2 = new String[]{"Brown", "Blue", "Grey", "Green", "Other"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        spnEyeColor.setAdapter(adapter2);

        spnHairColor = (Spinner) findViewById(R.id.spnHairColor);
        String[] items3 = new String[]{"Brown", "Blonde", "Black", "Ginger", "White", "Grey", "Other"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        spnHairColor.setAdapter(adapter3);
    }

    public void goToRegi1(View view) {
        Intent toRegi1 = new Intent(this, Register1Basic.class);
        startActivity(toRegi1);
    }

    public void goToRegi3(View view) {
        Intent toRegi3 = new Intent(this, Register3Weird.class);

        startActivity(toRegi3);
    }
}
