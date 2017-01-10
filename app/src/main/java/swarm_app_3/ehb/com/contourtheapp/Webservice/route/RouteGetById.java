package swarm_app_3.ehb.com.contourtheapp.Webservice.route;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.Role;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.role.RoleWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class RouteGetById extends SimpleWebrequest<Role> {

    public RouteGetById(int id, Response.Listener<Role> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, RoleWebservice.BASISURL + "getById", Kenmerk.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("RouteId", Integer.toString(id));
    }
}

