package swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.Usercoordinaat;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 09/01/2017.
 */

public class UsercoordinaatGetById extends SimpleWebrequest<Usercoordinaat> {

    public UsercoordinaatGetById(int id, Response.Listener<Usercoordinaat> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UsercoordinaatWebservice.BASISURL + "getById", Usercoordinaat.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("UsercoordinaatId", Integer.toString(id));
    }
}

