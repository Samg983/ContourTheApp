package swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerk;

import com.android.volley.Request;
import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class KenmerkVoegToe extends SimpleWebrequest<String> {

    public KenmerkVoegToe(Kenmerk teVerzendenProduct, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Request.Method.POST, KenmerkWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenProduct;
    }

}