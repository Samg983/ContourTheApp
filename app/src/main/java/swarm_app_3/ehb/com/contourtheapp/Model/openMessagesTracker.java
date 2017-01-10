package swarm_app_3.ehb.com.contourtheapp.Model;

        import android.app.Activity;
        import android.app.Dialog;
        import android.content.ContentResolver;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.Typeface;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.provider.MediaStore;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.io.File;

        import swarm_app_3.ehb.com.contourtheapp.Activities.TrackerActivity;
        import swarm_app_3.ehb.com.contourtheapp.R;

        import static com.google.android.gms.instantapps.InstantApps.getPackageManager;

/**
 * Created by SamGoeman on 25/12/2016.
 */

public class OpenMessagesTracker extends Dialog implements android.view.View.OnClickListener {
    public Activity activity;
    public TextView lblMessage, lblMoveAlong, lblHiCutie, lblWalkOnTheLine, lblTakePhoto;
    private static final int TAKE_PICTURE = 1;
    private Uri imageUri;

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
        lblTakePhoto = (TextView) findViewById(R.id.lblTakePhoto);

        lblMessage.setTypeface(ralewayRegular);
        lblMoveAlong.setTypeface(cutive);
        lblHiCutie.setTypeface(cutive);
        lblWalkOnTheLine.setTypeface(cutive);
        lblTakePhoto.setTypeface(cutive);

        lblTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photo));
                imageUri = Uri.fromFile(photo);
                activity.startActivityForResult(intent, TAKE_PICTURE);

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
