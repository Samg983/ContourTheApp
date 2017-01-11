package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerkwaarde;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerkwaarde.KenmerkwaardeVoegToe;

public class Register2Personal extends AppCompatActivity {

    private TextView lblTitleRegi2, lblHeight, lblGender, lblEyeColor, lblHairColor, lblNextRegi2, lblPrevRegi2;
    private EditText txtHeight;
    private Spinner spnGender, spnEyeColor, spnHairColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_personal);

        setItems();

        Bundle mijnOpgehaaldeGegevens = getIntent().getExtras();

        String dateOfBirth = mijnOpgehaaldeGegevens.get("dateOfBirth").toString();
        String city = mijnOpgehaaldeGegevens.get("city").toString();

        KenmerkwaardeVoegToe kenmerkwaardeDateOfBirth = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, dateOfBirth, 3), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Geslaagd geboortedatum", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeCity = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, city, 5), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Geslaagd city", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(kenmerkwaardeDateOfBirth);
        Webservice.getRequestQueue().add(kenmerkwaardeCity);


    }

    public void goToRegi1(View view) {
        this.finish();
    }

    public void goToRegi3(View view) {
        Intent toRegi3 = new Intent(this, Register3Weird.class);

        startActivity(toRegi3);
    }

    public void setItems() {
        lblTitleRegi2 = (TextView) findViewById(R.id.lblTitleRegi2);
        lblHeight = (TextView) findViewById(R.id.lblHeight);
        lblEyeColor = (TextView) findViewById(R.id.lblEyeColor);
        lblHairColor = (TextView) findViewById(R.id.lblHairColor);
        lblNextRegi2 = (TextView) findViewById(R.id.lblNextRegi2);
        lblPrevRegi2 = (TextView) findViewById(R.id.lblPrevRegi2);
        lblGender = (TextView) findViewById(R.id.lblGender);

        txtHeight = (EditText) findViewById(R.id.txtHeight);

        final Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");

        lblTitleRegi2.setTypeface(customFonts);
        lblHeight.setTypeface(customFonts);
        lblEyeColor.setTypeface(customFonts);
        lblHairColor.setTypeface(customFonts);
        lblNextRegi2.setTypeface(customFonts);
        lblPrevRegi2.setTypeface(customFonts);
        lblGender.setTypeface(customFonts);
        txtHeight.setTypeface(customFonts);
        //TextView lblCustomSpinner = (TextView) findViewById(R.id.lblCustomSpinner);
        //lblCustomSpinner.setTypeface(customFonts);

        spnGender = (Spinner) findViewById(R.id.spnGender);
        String[] genderItems = new String[]{"Male", "Female", "Other"};

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, genderItems) {
            @Override
            public View getDropDownView(int position, View convertView,
                    ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;


                // Set the Text color
                tv.setTextColor(Color.BLACK);
                tv.setTypeface(customFonts);


                return view;
            }
        };

        spnGender.setAdapter(genderAdapter);

        spnEyeColor = (Spinner) findViewById(R.id.spnEyeColor);
        String[] eyeColorItems = new String[]{"Brown", "Blue", "Grey", "Green", "Other"};
        ArrayAdapter<String> eyeColorAdapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, eyeColorItems){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                // Set the Text color
                tv.setTextColor(Color.BLACK);
                tv.setTypeface(customFonts);

                return view;
            }
        };
        spnEyeColor.setAdapter(eyeColorAdapter);

        spnHairColor = (Spinner) findViewById(R.id.spnHairColor);
        String[] hairColorItems = new String[]{"Brown", "Blonde", "Black", "Ginger", "White", "Grey", "Other"};
        ArrayAdapter<String> hairColorAdapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, hairColorItems){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                // Set the Text color
                tv.setTextColor(Color.BLACK);

                return view;
            }
        };
        spnHairColor.setAdapter(hairColorAdapter);
    }
}
