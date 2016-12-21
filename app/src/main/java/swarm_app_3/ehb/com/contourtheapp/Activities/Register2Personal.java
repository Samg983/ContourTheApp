package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import swarm_app_3.ehb.com.contourtheapp.R;

public class Register2Personal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2_personal);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Male", "Female", "Other", "Not sure"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

<<<<<<< HEAD
    public void goToRegiDrie(View view) {
        Intent toRegiDrie = new Intent(this, Register3Weird.class);
        startActivity(toRegiDrie);
=======
        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{"Amber", "Hazel", "Brown", "Green", "Blue", "Grey"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown.setAdapter(adapter2);

>>>>>>> origin/master
    }
}
