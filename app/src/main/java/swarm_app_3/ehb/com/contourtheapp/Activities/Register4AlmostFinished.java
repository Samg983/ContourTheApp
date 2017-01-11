package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Register4AlmostFinished extends AppCompatActivity {
    private TextView lblTitleRegi4, lblComeToItaly, lblHowMany, lblPrevRegi4, lblFinish;
    private int opgehaaldUserId, kenmerkwaardeComeToItalyId, kenmerkwaardeHowManyId;
    private Spinner spnComeToItaly, spnHowMany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4_almost_finished);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        opgehaaldUserId = preferences.getInt("userId", 0);
        setItems();

    }

    private void setItems() {
        lblTitleRegi4 = (TextView) findViewById(R.id.lblTitleRegi4);
        lblComeToItaly = (TextView) findViewById(R.id.lblComeToItaly);
        lblHowMany = (TextView) findViewById(R.id.lblHowMany);
        lblPrevRegi4 = (TextView) findViewById(R.id.lblPrevRegi4);
        lblFinish = (TextView) findViewById(R.id.lblFinish);

        final Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");

        lblTitleRegi4.setTypeface(customFonts);
        lblComeToItaly.setTypeface(customFonts);
        lblHowMany.setTypeface(customFonts);
        lblPrevRegi4.setTypeface(customFonts);
        lblFinish.setTypeface(customFonts);

        spnComeToItaly = (Spinner) findViewById(R.id.spnComeToItaly);
        String[] items = new String[]{"Yes", "No", "Maybe"};
        ArrayAdapter<String> adapterComeToItaly = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, items) {
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
        spnComeToItaly.setAdapter(adapterComeToItaly);

        spnHowMany = (Spinner) findViewById(R.id.spnHowMany);
        String[] amount = new String[]{"0", "1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> adapterHowMany = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, amount) {
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
        spnHowMany.setAdapter(adapterHowMany);
    }

    public void goToRegi3(View view) {
        this.finish();
    }

    public void goToHome(View view) {


        String opgehaaldeComeToItaly = spnComeToItaly.getSelectedItem().toString();
        String opgehaaldeHowMany = spnHowMany.getSelectedItem().toString();

        KenmerkwaardeVoegToe kenmerkwaardeComeToItaly = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeComeToItaly, 12), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kenmerkwaardeComeToItalyId = Integer.parseInt(response);
                voegUserKenmerkWaardeComeToItalyToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        KenmerkwaardeVoegToe kenmerkwaardeHowMany = new KenmerkwaardeVoegToe(new Kenmerkwaarde(0, opgehaaldeHowMany, 13), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kenmerkwaardeHowManyId = Integer.parseInt(response);
                voegUserKenmerkWaardeHowManyToe();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(kenmerkwaardeComeToItaly);
        Webservice.getRequestQueue().add(kenmerkwaardeHowMany);


        Intent toHome = new Intent(this, HomeScreen.class);
        startActivity(toHome);
    }

    private void voegUserKenmerkWaardeComeToItalyToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeComeToItalyVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeComeToItalyId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeComeToItalyVoegToe);
    }

    private void voegUserKenmerkWaardeHowManyToe() {
        UserkenmerkwaardeVoegToe userkenmerkwaardeHowManyVoegToe = new UserkenmerkwaardeVoegToe(new Userkenmerkwaarde(0, kenmerkwaardeHowManyId, opgehaaldUserId), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Webservice.getRequestQueue().add(userkenmerkwaardeHowManyVoegToe);
    }
}
