package swarm_app_3.ehb.com.contourtheapp.Adapters;

import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public interface SectionStateChangeListener {

    void onSectionStateChanged(Checkpoint section, boolean isOpen);

}
