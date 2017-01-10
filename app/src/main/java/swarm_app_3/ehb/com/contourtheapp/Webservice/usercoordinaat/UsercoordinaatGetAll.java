package swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 09/01/2017.
 */

public class UsercoordinaatGetAll extends SimpleWebrequest<String> {

    public UsercoordinaatGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UsercoordinaatWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}