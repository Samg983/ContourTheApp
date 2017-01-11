package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register4AlmostFinished extends AppCompatActivity {
    private TextView lblTitleRegi4, lblComeToItaly, lblHowMany, lblPrevRegi4, lblFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4_almost_finished);

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

        Spinner spnComeToItaly = (Spinner) findViewById(R.id.spnComeToItaly);
        String[] items = new String[]{"Yes", "No", "Maybe"};
        ArrayAdapter<String> adapterComeToItaly = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, items){
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

        Spinner spnHowMany = (Spinner) findViewById(R.id.spnHowMany);
        String[] amount = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> adapterHowMany = new ArrayAdapter<String>(this, R.layout.custom_spinner_layout, amount){
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
        Intent toHome = new Intent(this, HomeScreen.class);
        startActivity(toHome);
    }
}
