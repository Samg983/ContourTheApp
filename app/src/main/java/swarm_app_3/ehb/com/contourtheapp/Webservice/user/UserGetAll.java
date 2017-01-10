package swarm_app_3.ehb.com.contourtheapp.Webservice.user;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class UserGetAll extends SimpleWebrequest<String> {

    public UserGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UserWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}