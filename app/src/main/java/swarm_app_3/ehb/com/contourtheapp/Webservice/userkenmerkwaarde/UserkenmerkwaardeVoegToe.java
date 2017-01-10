package swarm_app_3.ehb.com.contourtheapp.Webservice.userkenmerkwaarde;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Usercoordinaat;
import swarm_app_3.ehb.com.contourtheapp.Model.Userkenmerkwaarde;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.usercoordinaat.UsercoordinaatWebservice;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class UserkenmerkwaardeVoegToe extends SimpleWebrequest<String> {

    public UserkenmerkwaardeVoegToe(Userkenmerkwaarde teVerzendenUserkenmerkwaarde, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, UserkenmerkwaardeWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenUserkenmerkwaarde;
    }

}