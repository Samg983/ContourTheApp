package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register3Weird extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3_weird);
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
