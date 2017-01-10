package swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.User;
import swarm_app_3.ehb.com.contourtheapp.Model.Usercoordinaat;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.user.UserWebservice;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class UsercoordinaatVoegToe extends SimpleWebrequest<String> {

    public UsercoordinaatVoegToe(Usercoordinaat teVerzendenUsercoordinaat, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, UsercoordinaatWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenUsercoordinaat;
    }

}