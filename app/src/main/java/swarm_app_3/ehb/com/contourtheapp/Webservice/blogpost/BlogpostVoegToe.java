package swarm_app_3.ehb.com.contourtheapp.Webservice.blogpost;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Blogpost;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;



/**
 * Created by SamGoeman on 10/01/2017.
 */

public class BlogpostVoegToe extends SimpleWebrequest<String> {

    public BlogpostVoegToe(Blogpost teVerzendenBlogpost, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, BlogpostWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenBlogpost;
    }

}