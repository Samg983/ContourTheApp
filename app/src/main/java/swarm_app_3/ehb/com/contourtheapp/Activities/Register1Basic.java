package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.android.volley.Response;
import com.android.volley.VolleyError;

import swarm_app_3.ehb.com.contourtheapp.Model.Inschrijving;
import swarm_app_3.ehb.com.contourtheapp.Model.User;
import swarm_app_3.ehb.com.contourtheapp.R;
import swarm_app_3.ehb.com.contourtheapp.Webservice.Webservice;
import swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving.InschrijvingVoegToe;
import swarm_app_3.ehb.com.contourtheapp.Webservice.user.UserVoegToe;

public class Register1Basic extends AppCompatActivity {

    private TextView lblNext, lblTitelRegi1, lblName, lblDateOfBirth, lblCity, lblFirstNameRegi1;
    private EditText txtName, txtDateOfBirth, txtCity, txtFirstNameRegi1;
    private TelephonyManager telephonyManager;
    private static final int MY_PERMISSIONS_REQUEST_TELEPHONESTATE = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1_basic);

        //requesten om phonegegevens te lezen (nodig voor imeinummer)
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_TELEPHONESTATE);
        setItems();
    }

    private void setItems() {
        //alle velden ophalen + fonts zetten
        lblTitelRegi1 = (TextView) findViewById(R.id.lblTitleRegi1);
        lblNext = (TextView) findViewById(R.id.lblNextRegi1);
        lblName = (TextView) findViewById(R.id.lblNameRegi1);
        lblDateOfBirth = (TextView) findViewById(R.id.lblDateOfBirthRegi1);
        lblCity = (TextView) findViewById(R.id.lblCityRegi1);
        lblFirstNameRegi1 = (TextView) findViewById(R.id.lblFirstNameRegi1);

        txtName = (EditText) findViewById(R.id.txtNameRegi1);
        txtDateOfBirth = (EditText) findViewById(R.id.txtDateOfBirthRegi1);
        txtCity = (EditText) findViewById(R.id.txtCityRegi1);
        txtFirstNameRegi1 = (EditText) findViewById(R.id.txtFirstNameRegi1);


        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        lblTitelRegi1.setTypeface(customFonts);
        lblNext.setTypeface(customFonts);
        lblName.setTypeface(customFonts);
        lblDateOfBirth.setTypeface(customFonts);
        lblCity.setTypeface(customFonts);
        lblFirstNameRegi1.setTypeface(customFonts);

        txtName.setTypeface(customFonts);
        txtDateOfBirth.setTypeface(customFonts);
        txtCity.setTypeface(customFonts);
        txtFirstNameRegi1.setTypeface(customFonts);
    }

    public void goToRegi2(View view) {

        //tekst uit de inputvelden halen
        String lastName = txtName.getText().toString();
        String firstName = txtFirstNameRegi1.getText().toString();

        //nieuwe user toevoegen, request naar de server
        UserVoegToe userVoegToe = new UserVoegToe(new User(0, lastName, firstName, getImeiNumber(), 1), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Intent toRegi2 = new Intent(Register1Basic.this, Register2Personal.class);

                toRegi2.putExtra("dateOfBirth", txtDateOfBirth.getText().toString());
                toRegi2.putExtra("city", txtCity.getText().toString());


                Log.d("id user", response);
                voegInschrijvingToe(Integer.parseInt(response));

                startActivity(toRegi2);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("FAILED User toevoegen", error.toString());
            }
        });

        Webservice.getRequestQueue().add(userVoegToe);

    }

    private String getImeiNumber() {

        //imeinummer ophalen, door eerst te checken of er permission is gegeven. De methode returnt het imeinummer
        String IMEI_Number_Holder = "";
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
            IMEI_Number_Holder = telephonyManager.getDeviceId();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_TELEPHONESTATE);
        }
        return IMEI_Number_Holder;
    }

    private void voegInschrijvingToe(final int userIdFromResponse){

        //nieuwe inschrijving toevoegen
        InschrijvingVoegToe inschrijvingVoegToe = new InschrijvingVoegToe(new Inschrijving(0, "vandaag", 1, userIdFromResponse), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                setSharedPreferences(userIdFromResponse, Integer.parseInt(response), true);
                Log.d("id inschrijving", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        Webservice.getRequestQueue().add(inschrijvingVoegToe);
    }

    private void setSharedPreferences(int userId, int inschrijvingsId, boolean alreadySubscribed){

        //alles opslaan in sharedpreferences zoda hij de gegevens onthoudt wanneer de app gesloten wordt.
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("userId", userId);
        editor.putInt("inschrijvingsId", inschrijvingsId);
        editor.putBoolean("alreadySubscribed", alreadySubscribed);
        editor.commit();
    }

}
