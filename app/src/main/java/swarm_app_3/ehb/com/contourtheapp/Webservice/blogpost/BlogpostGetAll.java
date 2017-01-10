package swarm_app_3.ehb.com.contourtheapp.Webservice.blogpost;

import com.android.volley.Request;
import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;

/**
 * Created by Bram Schrooyen on 10/01/2017.
 */

public class BlogpostGetAll extends SimpleWebrequest<String> {

    public BlogpostGetAll(Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Request.Method.GET, BlogpostWebservice.BASISURL + "getAll", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
    }
}
