package swarm_app_3.ehb.com.contourtheapp.Webservice.inschrijving;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Inschrijving;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 10/01/2017.
 */

public class InschrijvingVoegToe extends SimpleWebrequest<String> {

    public InschrijvingVoegToe(Inschrijving teVerzendenInschrijving, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, InschrijvingWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenInschrijving;
    }

}