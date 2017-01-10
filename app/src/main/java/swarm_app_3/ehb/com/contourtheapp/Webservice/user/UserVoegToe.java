package swarm_app_3.ehb.com.contourtheapp.Webservice.user;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Role;
import swarm_app_3.ehb.com.contourtheapp.Model.User;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.role.RoleWebservice;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class UserVoegToe extends SimpleWebrequest<String> {

    public UserVoegToe(User teVerzendenUser, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, UserWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenUser;
    }

}