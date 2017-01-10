package swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Inschrijving;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class InschrijvingGetById extends SimpleWebrequest<Inschrijving> {

    public InschrijvingGetById(int id, Response.Listener<Inschrijving> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, InschrijvingWebservice.BASISURL + "getById", Inschrijving.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("InschrijvingsId", Integer.toString(id));
    }
}

