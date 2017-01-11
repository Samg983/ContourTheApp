package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by SamGoeman on 20/12/2016.
 */


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import swarm_app_3.ehb.com.contourtheapp.Activities.Register1Basic;
import swarm_app_3.ehb.com.contourtheapp.R;


public class OpenDialogSwarmInfo extends Dialog implements android.view.View.OnClickListener {

    private Activity activity;
    private Button subscribeButton;
    private TextView lblMoreInfoSwarm;

    public OpenDialogSwarmInfo() {
        super(null);
    }

    public OpenDialogSwarmInfo(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.extra_info_swarm);

        lblMoreInfoSwarm = (TextView) findViewById(R.id.lblMoreInfoSwarm);

        Typeface ralewayRegular = Typeface.createFromAsset(activity.getAssets(), "Raleway-Regular.ttf");

        lblMoreInfoSwarm.setTypeface(ralewayRegular);

        subscribeButton = (Button) findViewById(R.id.btnSubscribe);
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSubscribeFromSwarm = new Intent(getContext(), Register1Basic.class);
                getContext().startActivity(goToSubscribeFromSwarm);
            }
        });


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        Boolean alreadySubscribed = preferences.getBoolean("alreadySubscribed", false);

       if(alreadySubscribed) subscribeButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
        dismiss();


    }

}

