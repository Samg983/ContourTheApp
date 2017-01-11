package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
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
import swarm_app_3.ehb.com.contourtheapp.Model.Userkenmerkwaarde;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerkwaarde.KenmerkwaardeVoegToe;
import swarm_app_3.ehb.com.contourtheapp.Webservice.userkenmerkwaarde.UserkenmerkwaardeVoegToe;

public class Register2Personal extends AppCompatActivity {

    private TextView lblTitleRegi2, lblHeight, lblGender, lblEyeColor, lblHairColor, lblNextRegi2, lblPrevRegi2;
    private EditText txtHeight;
    private Spinner spnGender, spnEyeColor, spnHairColor;
    private int kenmerkwaardeDateOfBirthId, kenmerkwaardeCityId, opgehaaldUserId, kenmerkwaardeGenderId, kenmerkwaardeHeightId, kenmerkwaardeEyeColorId, kenmerkwaardeHairColorId;
    private String city;
    private ArrayAdapter<String> eyeColorAdapter, hairColorAdapter, genderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_personal);

        setItems();

        Bundle mijnOpgehaaldeGegevens = getIntent().getExtras();


        String dateOfBirth = mijnOpgehaaldeGegevens.get("dateOfBirth").toString();
        city = mijnOpgehaaldeGegevens.get("city").toString();


        SharedPreferences preferences =PreferenceManager.getDefaultSharedPreferences(this);
        opgehaaldUserId = preferences.getInt("userId", 0);

        Log.d("opgehaalduserID", ""+opgehaaldUserId);
        KenmerkwaardeVoegToe kenmerkwaardeDateOfBirth = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, dateOfBirth, 3), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("DATE OF BIRTH", response);
                kenmerkwaardeDateOfBirthId = Integer.parseInt(response);
                voegUserKenmerkWaardeDateOfBirthToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeCity = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, city, 5), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("CITY", response);
                kenmerkwaardeCityId = Integer.parseInt(response);
                voegUserKenmerkWaardeCityToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(kenmerkwaardeCity);
        Webservice.getRequestQueue().add(kenmerkwaardeDateOfBirth);

    }

    private void voegUserKenmerkWaardeCityToe(){
        UserkenmerkwaardeVoegToe userkenmerkwaardeCityVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeCityId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("userCITY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("user city err", error.toString());
            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeCityVoegToe);
    }

    private void voegUserKenmerkWaardeDateOfBirthToe(){
        UserkenmerkwaardeVoegToe userkenmerkwaardeDateOfBirthVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeDateOfBirthId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("user birth", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("user birth err", error.toString());
            }
        });
        Webservice.getRequestQueue().add(userkenmerkwaardeDateOfBirthVoegToe);
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


        spnGender = (Spinner) findViewById(R.id.spnGender);
        String[] genderItems = new String[]{"Male", "Female", "Other"};

        genderAdapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, genderItems) {
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
        eyeColorAdapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, eyeColorItems){
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
        hairColorAdapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, hairColorItems){
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

    public void goToRegi1(View view) {



        this.finish();
    }

    public void goToRegi3(View view) {

        String opgehaaldeHeight = txtHeight.getText().toString();
        String opgehaaldeGender = spnGender.getSelectedItem().toString();
        String opgehaaldeEyeColor = spnEyeColor.getSelectedItem().toString();
        String opgehaaldeHairColor = spnHairColor.getSelectedItem().toString();


        KenmerkwaardeVoegToe kenmerkwaardeHeight = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeHeight, 6), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("height", response);
                kenmerkwaardeHeightId = Integer.parseInt(response);
                voegUserKenmerkWaardeHeightToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeGender = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeGender, 7), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("gender", response);
                kenmerkwaardeGenderId = Integer.parseInt(response);
                voegUserKenmerkWaardeGenderToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeEyeColor = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeEyeColor, 8), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("eyecolor", response);
                kenmerkwaardeEyeColorId = Integer.parseInt(response);
                voegUserKenmerkWaardeEyeColorToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeHairColor = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeHairColor, 9), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("haircolor", response);
                kenmerkwaardeHairColorId = Integer.parseInt(response);
                voegUserKenmerkWaardeHairColorToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(kenmerkwaardeGender);
        Webservice.getRequestQueue().add(kenmerkwaardeHeight);
        Webservice.getRequestQueue().add(kenmerkwaardeEyeColor);
        Webservice.getRequestQueue().add(kenmerkwaardeHairColor);

        Intent toRegi3 = new Intent(this, Register3Weird.class);
        toRegi3.putExtra("userId", opgehaaldUserId);
        startActivity(toRegi3);
    }

    private void voegUserKenmerkWaardeHeightToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeHeightVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeHeightId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeHeightVoegToe);
    }
    private void voegUserKenmerkWaardeGenderToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeGenderVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeGenderId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeGenderVoegToe);
    }
    private void voegUserKenmerkWaardeHairColorToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeHairColorVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeHairColorId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeHairColorVoegToe);
    }
    private void voegUserKenmerkWaardeEyeColorToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeEyeColorVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeEyeColorId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeEyeColorVoegToe);
    }
}
