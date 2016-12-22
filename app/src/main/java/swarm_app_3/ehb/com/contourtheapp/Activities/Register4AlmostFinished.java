package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register4AlmostFinished extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4_almost_finished);
    }
    public void goToRegi3 (View view) {
        Intent toRegi3 = new Intent(this, Register3Weird.class);
        startActivity(toRegi3);
    }
}
