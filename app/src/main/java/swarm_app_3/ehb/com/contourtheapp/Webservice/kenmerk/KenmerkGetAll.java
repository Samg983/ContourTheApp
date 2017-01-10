package swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class KenmerkGetAll extends SimpleWebrequest<String> {

    public KenmerkGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Request.Method.GET, KenmerkWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}