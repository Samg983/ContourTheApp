package swarm_app_3.ehb.com.contourtheapp.Webservice.blogpost;

import com.android.volley.Response;

import java.util.HashMap;

import swarm_app_3.ehb.com.contourtheapp.Model.Blogpost;
import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;
import swarm_app_3.ehb.com.contourtheapp.Webservice.checkpoint.CheckpointWebservice;

/**
 * Created by SamGoeman on 09/01/2017.
 */

public class BlogpostGetById extends SimpleWebrequest<Blogpost> {

    public BlogpostGetById(int id, Response.Listener<Blogpost> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.GET, BlogpostWebservice.BASISURL + "getById", Blogpost.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);
        this.teVerzendenParameters = new HashMap<String, String>();
        this.teVerzendenParameters.put("CheckpointId", Integer.toString(id));
    }
}

