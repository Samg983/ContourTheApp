package swarm_app_3.ehb.com.contourtheapp.Activities;

import android.app.Application;
import android.content.Context;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class MijnApplicatie extends Application {

        private static Context mijnContext;

        @Override
        public void onCreate() {
            super.onCreate();
            mijnContext = getApplicationContext();
        }

        public static Context getContext(){
            return mijnContext;

        }
    }
