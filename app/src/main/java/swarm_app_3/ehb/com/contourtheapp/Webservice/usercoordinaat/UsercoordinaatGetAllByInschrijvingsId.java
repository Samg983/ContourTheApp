package swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 11/01/2017.
 */

public class UsercoordinaatGetAllByInschrijvingsId extends SimpleWebrequest<String> {

    public UsercoordinaatGetAllByInschrijvingsId(int id, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UsercoordinaatWebservice.BASISURL + "getAllByInschrijvingsId", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("InschrijvingsId", Integer.toString(id));
    }}