package swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class InschrijvingGetAll extends SimpleWebrequest<String> {

    public InschrijvingGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, InschrijvingWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}