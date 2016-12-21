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

    public void goToNextPage(View view) {
        Intent toNextPage = new Intent(this, MapsActivity.class);
        startActivity(toNextPage);
    }
}
