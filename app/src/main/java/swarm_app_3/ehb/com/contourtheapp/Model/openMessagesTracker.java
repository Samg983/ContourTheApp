package swarm_app_3.ehb.com.contourtheapp.Model;

        import android.app.Activity;
        import android.app.Dialog;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.TextView;

        import swarm_app_3.ehb.com.contourtheapp.Activities.TrackerActivity;
        import swarm_app_3.ehb.com.contourtheapp.R;

/**
 * Created by SamGoeman on 25/12/2016.
 */

public class OpenMessagesTracker extends Dialog implements android.view.View.OnClickListener {
    public Activity activity;
    public TextView lblMessage, lblMoveAlong, lblHiCutie, lblWalkOnTheLine;

    public OpenMessagesTracker() {
        super(null);
    }

    public OpenMessagesTracker(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.messages_tracker);

        Typeface ralewayRegular = Typeface.createFromAsset(activity.getAssets(), "Raleway-Regular.ttf");
        Typeface cutive = Typeface.createFromAsset(activity.getAssets(), "CutiveMono-Regular.ttf");

        lblMessage = (TextView) findViewById(R.id.lblInformationMessageTracker);
        lblMoveAlong = (TextView) findViewById(R.id.lblMoveAlong);
        lblHiCutie = (TextView) findViewById(R.id.lblHi);
        lblWalkOnTheLine = (TextView) findViewById(R.id.lblWalkOnTheLine);

        lblMessage.setTypeface(ralewayRegular);
        lblMoveAlong.setTypeface(cutive);
        lblHiCutie.setTypeface(cutive);
        lblWalkOnTheLine.setTypeface(cutive);


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
