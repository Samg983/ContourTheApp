package swarm_app_3.ehb.com.contourtheapp.Webservice.photo;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Kenmerk;
import swarm_app_3.ehb.com.contourtheapp.Model.Photo;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.kenmerkwaarde.KenmerkwaardeWebservice;

/**
 * Created by SamGoeman on 10/01/2017.
 */

public class PhotoVoegToe extends SimpleWebrequest<String> {

    public PhotoVoegToe(Photo teVerzendenPhoto, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, PhotoWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenPhoto;
    }

}