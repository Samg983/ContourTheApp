package swarm_app_3.ehb.com.contourtheapp.Webservice.user;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.Role;
import swarm_app_3.ehb.com.contourtheapp.Model.User;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.role.RoleWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class UserGetById extends SimpleWebrequest<User> {

    public UserGetById(int id, Response.Listener<User> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, UserWebservice.BASISURL + "getById", Kenmerk.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("UserId", Integer.toString(id));
    }
}

