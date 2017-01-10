package swarm_app_3.ehb.com.contourtheapp.Webservice.userkenmerkwaarde;

import com.android.volley.Response;

import java.util.HashMap;


import swarm_app_3.ehb.com.contourtheapp.Model.Userkenmerkwaarde;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 09/01/2017.
 */

public class UserkenmerkwaardeGetById extends SimpleWebrequest<Userkenmerkwaarde> {

    public UserkenmerkwaardeGetById(int id, Response.Listener<Userkenmerkwaarde> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UserkenmerkwaardeWebservice.BASISURL + "getById", Userkenmerkwaarde.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("UsercoordinaatId", Integer.toString(id));
    }
}

