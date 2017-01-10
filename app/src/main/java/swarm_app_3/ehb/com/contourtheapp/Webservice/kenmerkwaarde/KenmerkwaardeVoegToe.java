package swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerkwaarde;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerkwaarde;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk.KenmerkWebservice;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class KenmerkwaardeVoegToe extends SimpleWebrequest<String> {

    public KenmerkwaardeVoegToe(Kenmerkwaarde teVerzendenKenmerk, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, KenmerkwaardeWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenKenmerk;
    }

}