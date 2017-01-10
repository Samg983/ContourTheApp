package swarm_app_3.ehb.com.contourtheapp.Webservice.photo;

import com.android.volley.Response;

import java.util.HashMap;
import swarm_app_3.ehb.com.contourtheapp.Model.Photo;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 09/01/2017.
 */

public class PhotoGetById extends SimpleWebrequest<Photo> {

    public PhotoGetById(int id, Response.Listener<Photo> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, PhotoWebservice.BASISURL + "getById", Photo.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("PhotoId", Integer.toString(id));
    }
}

