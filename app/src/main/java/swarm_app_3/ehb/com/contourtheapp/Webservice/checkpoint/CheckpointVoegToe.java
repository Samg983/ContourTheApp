package swarm_app_3.ehb.com.contourtheapp.Webservice.checkpoint;

import com.android.volley.Response;

import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;;
import swarm_app_3.ehb.com.contourtheapp.Webservice.SimpleWebrequest;


/**
 * Created by SamGoeman on 10/01/2017.
 */

public class CheckpointVoegToe extends SimpleWebrequest<String> {

    public CheckpointVoegToe(Checkpoint teVerzendenCheckpoint, Response.Listener<String> uitvoerenIndienGeslaagd, Response.ErrorListener uitvoerenIndienNietGeslaagd) {
        super(Method.POST, CheckpointWebservice.BASISURL + "voegToe", String.class, uitvoerenIndienGeslaagd, uitvoerenIndienNietGeslaagd);

        this.teVerzendenObjectAlsJson = teVerzendenCheckpoint;
    }

}