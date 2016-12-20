package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by SamGoeman on 20/12/2016.
 */


    import android.app.Activity;
    import android.app.Dialog;
    import android.os.Bundle;
    import android.view.View;
    import android.view.Window;

    import swarm_app_3.ehb.com.contourtheapp.R;


public class OpenDialog extends Dialog implements android.view.View.OnClickListener {

        public Activity activity;

        public OpenDialog() {
            super(null);
        }
        public OpenDialog(Activity activity) {
            super(activity);
            this.activity = activity;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.extrainfoswarm);
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

