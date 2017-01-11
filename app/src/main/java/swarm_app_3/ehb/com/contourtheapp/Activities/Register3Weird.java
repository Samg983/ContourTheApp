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

public class Register3Weird extends AppCompatActivity {
    private TextView lblToes, lblFingers, lblShoeSize, lblNoseLength, lblDimples, lblNextRegi3, lblPrevRegi3, lblTitleRegi3;
    private Spinner spnNoseLength, spnDimples, spnFingers, spnToes, spnShoeSize;
    private int kenmerkwaardeNoseLengthId, kenmerkwaardeDimplesId, kenmerkwaardeFingersId, kenmerkwaardeToesId, kenmerkwaardeShoeSizeId, opgehaaldUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3_weird);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        opgehaaldUserId = preferences.getInt("userId", 0);

        setItems();
    }

    private void setItems() {
        lblTitleRegi3 = (TextView) findViewById(R.id.lblTitleRegi3);
        lblToes = (TextView) findViewById(R.id.lblToes);
        lblFingers = (TextView) findViewById(R.id.lblFingers);
        lblShoeSize = (TextView) findViewById(R.id.lblShoeSize);
        lblNoseLength = (TextView) findViewById(R.id.lblNoseLength);
        lblDimples = (TextView) findViewById(R.id.lblDimples);
        lblNextRegi3 = (TextView) findViewById(R.id.lblNextRegi3);
        lblPrevRegi3 = (TextView) findViewById(R.id.lblPrevRegi3);


        final Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");

        lblTitleRegi3.setTypeface(customFonts);
        lblToes.setTypeface(customFonts);
        lblFingers.setTypeface(customFonts);
        lblShoeSize.setTypeface(customFonts);
        lblNoseLength.setTypeface(customFonts);
        lblDimples.setTypeface(customFonts);
        lblNextRegi3.setTypeface(customFonts);
        lblPrevRegi3.setTypeface(customFonts);


        spnNoseLength = (Spinner) findViewById(R.id.spnNoseLength);
        String[] noseLength = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterNoseLength = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, noseLength);
        spnNoseLength.setAdapter(adapterNoseLength);

        spnDimples = (Spinner) findViewById(R.id.spnDimples);
        String[] dimples = new String[]{"Yes", "No"};
        ArrayAdapter<String> adapterDimples = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, dimples) {
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
        spnDimples.setAdapter(adapterDimples);

        spnFingers = (Spinner) findViewById(R.id.spnFingers);
        String[] fingers = new String[]{"4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterFingers = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, fingers) {
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
        spnFingers.setAdapter(adapterFingers);

        spnToes = (Spinner) findViewById(R.id.spnToes);
        String[] toes = new String[]{"4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterToes = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, toes) {
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
        spnToes.setAdapter(adapterToes);

        spnShoeSize = (Spinner) findViewById(R.id.spnShoeSize);
        String[] shoeSize = new String[]{"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
        ArrayAdapter<String> adapterShoeSize = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, shoeSize) {
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
        spnShoeSize.setAdapter(adapterShoeSize);
    }

    public void goToRegi2(View view) {
        this.finish();
    }

    public void goToRegi4(View view) {


        String opgehaaldeNoseLength = spnNoseLength.getSelectedItem().toString();
        String opgehaaldeDimples = spnDimples.getSelectedItem().toString();
        String opgehaaldeFingers = spnFingers.getSelectedItem().toString();
        String opgehaaldeToes = spnToes.getSelectedItem().toString();
        String opgehaaldeShoeSize = spnShoeSize.getSelectedItem().toString();


        KenmerkwaardeVoegToe kenmerkwaardeNoseLength = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeNoseLength, 10), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kenmerkwaardeNoseLengthId = Integer.parseInt(response);
                voegUserKenmerkWaardeNoseLengthToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeDimples = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeDimples, 11), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kenmerkwaardeDimplesId = Integer.parseInt(response);
                voegUserKenmerkWaardeDimplesToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeFingers = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeFingers, 2), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kenmerkwaardeFingersId = Integer.parseInt(response);
                voegUserKenmerkWaardeFingersToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeToes = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeToes, 1), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("haircolor", response);
                kenmerkwaardeToesId = Integer.parseInt(response);
                voegUserKenmerkWaardeToesToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeShoeSize = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeShoeSize, 4), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("haircolor", response);
                kenmerkwaardeShoeSizeId = Integer.parseInt(response);
                voegUserKenmerkWaardeShoeSizeToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Webservice.getRequestQueue().add(kenmerkwaardeNoseLength);
        Webservice.getRequestQueue().add(kenmerkwaardeDimples);
        Webservice.getRequestQueue().add(kenmerkwaardeFingers);
        Webservice.getRequestQueue().add(kenmerkwaardeToes);
        Webservice.getRequestQueue().add(kenmerkwaardeShoeSize);

        Intent toRegi4 = new Intent(this, Register4AlmostFinished.class);
        startActivity(toRegi4);
    }

    private void voegUserKenmerkWaardeNoseLengthToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeNoseLengthVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeNoseLengthId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeNoseLengthVoegToe);
    }
    private void voegUserKenmerkWaardeDimplesToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeDimplesVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeDimplesId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeDimplesVoegToe);
    }
    private void voegUserKenmerkWaardeFingersToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeFingersVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeFingersId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeFingersVoegToe);

    }
    private void voegUserKenmerkWaardeToesToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeToesVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeToesId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeToesVoegToe);
    }
    private void voegUserKenmerkWaardeShoeSizeToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeShoeSizeVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeShoeSizeId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeShoeSizeVoegToe);
    }
}
