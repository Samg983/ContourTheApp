package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by SamGoeman on 20/12/2016.
 */


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import swarm_app_3.ehb.com.contourtheapp.Activities.Register1Basic;
import swarm_app_3.ehb.com.contourtheapp.R;


public class OpenDialogSwarmInfo extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Button subscribeButton;

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
        subscribeButton = (Button) findViewById(R.id.btnSubscribe);
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSubscribeFromSwarm = new Intent(getContext(), Register1Basic.class);
                getContext().startActivity(goToSubscribeFromSwarm);
            }
        });
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

