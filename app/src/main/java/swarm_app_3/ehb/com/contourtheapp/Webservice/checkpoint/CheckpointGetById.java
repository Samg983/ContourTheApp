package swarm_app_3.ehb.com.contourtheapp.Webservice.checkpoint;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.Inschrijving;
import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving.InschrijvingWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class CheckpointGetById extends SimpleWebrequest<Checkpoint> {

    public CheckpointGetById(int id, Response.Listener<Checkpoint> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, CheckpointWebservice.BASISURL + "getById", Kenmerk.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("CheckpointId", Integer.toString(id));
    }
}

