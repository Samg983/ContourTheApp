package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register1Basic extends AppCompatActivity {

    private TextView  lblNext, lblTitelRegi1, lblName, lblDateOfBirth, lblCity;
    private EditText txtName, txtDateOfBirth, txtCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1_basic);

        lblTitelRegi1 = (TextView) findViewById(R.id.lblTitleRegi1);
        lblNext = (TextView) findViewById(R.id.lblNextRegi1);
        lblName = (TextView) findViewById(R.id.lblNameRegi1);
        lblDateOfBirth = (TextView) findViewById(R.id.lblDateOfBirthRegi1);
        lblCity = (TextView) findViewById(R.id.lblCityRegi1);

        txtName = (EditText) findViewById(R.id.txtNameRegi1);
        txtDateOfBirth = (EditText) findViewById(R.id.txtDateOfBirthRegi1);
        txtCity = (EditText) findViewById(R.id.txtCityRegi1);


        Typeface customFonts = Typeface.createFromAsset(this.getAssets(), "CutiveMono-Regular.ttf");
        lblTitelRegi1.setTypeface(customFonts);
        lblNext.setTypeface(customFonts);
        lblName.setTypeface(customFonts);
        lblDateOfBirth.setTypeface(customFonts);
        lblCity.setTypeface(customFonts);

        txtName.setTypeface(customFonts);
        txtDateOfBirth.setTypeface(customFonts);
        txtCity.setTypeface(customFonts);

    }

    public void goToRegi2(View view) {
        Intent toRegi2 = new Intent(this, Register2Personal.class);
        toRegi2.putExtra("naam", txtName.getText().toString());
        toRegi2.putExtra("dateOfBirth", txtDateOfBirth.getText().toString());
        toRegi2.putExtra("city", txtCity.getText().toString());
        startActivity(toRegi2);
    }
}
