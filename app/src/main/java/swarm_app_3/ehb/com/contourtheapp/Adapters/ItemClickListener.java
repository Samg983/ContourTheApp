package swarm_app_3.ehb.com.contourtheapp.Adapters;

import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.Photo;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

//interface voor onclicklisteners bij de galllery
public interface ItemClickListener {

    void itemClicked(Photo item);
    void itemClicked(Checkpoint section);

}
