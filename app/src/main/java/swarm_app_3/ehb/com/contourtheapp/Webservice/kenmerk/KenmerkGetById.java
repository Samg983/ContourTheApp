package swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;


import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class KenmerkGetById extends SimpleWebrequest<Kenmerk> {

    public KenmerkGetById(int id, Response.Listener<Kenmerk> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Request.Method.GET, KenmerkWebservice.BASISURL + "getById", Kenmerk.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("kenmerkId", Integer.toString(id));
    }
}

