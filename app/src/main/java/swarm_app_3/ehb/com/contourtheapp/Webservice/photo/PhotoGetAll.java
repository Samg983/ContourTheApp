package swarm_app_3.ehb.com.contourtheapp.Webservice.photo;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class PhotoGetAll extends SimpleWebrequest<String> {

    public PhotoGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, PhotoWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}