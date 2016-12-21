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

    public void goToRegiVier(View view) {
        Intent toRegiVier = new Intent(this, Register4AlmostFinished.class);
        startActivity(toRegiVier);
    }
}
