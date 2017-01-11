package swarm_app_3.ehb.com.contourtheapp.Model;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import swarm_app_3.ehb.com.contourtheapp.R;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public class OpenDialogGalleryPhoto extends Dialog implements android.view.View.OnClickListener {

    private Activity activity;
    private int imgSrc;
    private ImageView imgPopUpGallery;

    public OpenDialogGalleryPhoto() {
        super(null);
    }

    public OpenDialogGalleryPhoto(Activity activity, int imgSrc) {
        super(activity);
        this.activity = activity;
        this.imgSrc = imgSrc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.open_gallery_photo);
        imgPopUpGallery = (ImageView) findViewById(R.id.imgPopUpGallery);
        imgPopUpGallery.setImageResource(imgSrc);



    }

    public int getImgSrc() {
        return imgSrc;
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