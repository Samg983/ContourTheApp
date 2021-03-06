package swarm_app_3.ehb.com.contourtheapp.Webservice.route;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Route;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.role.RoleWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class RouteGetById extends SimpleWebrequest<Route> {

    public RouteGetById(int id, Response.Listener<Route> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, RoleWebservice.BASISURL + "getById", Route.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("RouteId", Integer.toString(id));
    }
}

