package swarm_app_3.ehb.com.contourtheapp.Webservice.role;

import com.android.volley.Response;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.photo.PhotoWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class RoleGetAll extends SimpleWebrequest<String> {

    public RoleGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, PhotoWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}