package swarm_app_3.ehb.com.contourtheapp.Webservice.role;

import com.android.volley.Response;


import swarm_app_3.ehb.com.contourtheapp.Model.Role;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 10/01/2017.
 */

public class RoleVoegToe extends SimpleWebrequest<String> {

    public RoleVoegToe(Role teVerzendenRole, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, RoleWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenRole;
    }

}