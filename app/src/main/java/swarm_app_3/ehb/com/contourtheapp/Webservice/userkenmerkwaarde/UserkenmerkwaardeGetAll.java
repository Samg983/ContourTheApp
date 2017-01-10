package swarm_app_3.ehb.com.contourtheapp.Webservice.userkenmerkwaarde;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat.UsercoordinaatWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class UserkenmerkwaardeGetAll extends SimpleWebrequest<String> {

    public UserkenmerkwaardeGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UserkenmerkwaardeWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}