package swarm_app_3.ehb.com.contourtheapp.Webservice.checkpoint;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving.InschrijvingWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class CheckpointGetAll extends SimpleWebrequest<String> {

    public CheckpointGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, CheckpointWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}