package swarm_app_3.ehb.com.contourtheapp.Adapters;

import swarm_app_3.ehb.com.contourtheapp.Model.GalleryCheckpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.GalleryPhoto;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public interface ItemClickListener {

    void itemClicked(GalleryPhoto item);
    void itemClicked(GalleryCheckpoint section);

}
