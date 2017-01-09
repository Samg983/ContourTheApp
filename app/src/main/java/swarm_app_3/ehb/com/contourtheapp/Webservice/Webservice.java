package swarm_app_3.ehb.com.contourtheapp.Webservice;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import swarm_app_3.ehb.com.contourtheapp.Activities.MijnApplicatie;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Webservice {
    public static final String WEBSERVERURL = "http://10.3.50.49:8080/";
    private static RequestQueue mijnRequestQueue;

    public static RequestQueue getRequestQueue() {
        if (mijnRequestQueue == null) {

            mijnRequestQueue = Volley.newRequestQueue(MijnApplicatie.getContext());
        }

        return mijnRequestQueue;

    }
}
