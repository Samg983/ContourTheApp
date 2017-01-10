package swarm_app_3.ehb.com.contourtheapp.Webservice.route;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Role;
import swarm_app_3.ehb.com.contourtheapp.Model.Route;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.role.RoleWebservice;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class RouteVoegToe extends SimpleWebrequest<String> {

    public RouteVoegToe(Route teVerzendenRoute, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, RouteWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenRoute;
    }

}