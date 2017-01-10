package swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerkwaarde;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerkwaarde;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk.KenmerkWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class KenmerkwaardeGetById extends SimpleWebrequest<Kenmerkwaarde> {

    public KenmerkwaardeGetById(int id, Response.Listener<Kenmerkwaarde> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, KenmerkwaardeWebservice.BASISURL + "getById", Kenmerk.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("KenmerkwaardeId", Integer.toString(id));
    }
}

