package swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class GetAll extends SimpleWebrequest<ArrayList<Kenmerk>> {

    public GetAll(Response.Listener<ArrayList<Kenmerk>> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Request.Method.GET, KenmerkWebservice.BASISURL + "getAll", (new ArrayList<Kenmerk>()).getClass(), uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}