package swarm_app_3.ehb.com.contourtheapp.Webservice.role;

import com.android.volley.Response;
import java.util.HashMap;
import swarm_app_3.ehb.com.contourtheapp.Model.Role;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 09/01/2017.
 */

public class RoleGetById extends SimpleWebrequest<Role> {

    public RoleGetById(int id, Response.Listener<Role> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, RoleWebservice.BASISURL + "getById", Role.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("RoleId", Integer.toString(id));
    }
}

