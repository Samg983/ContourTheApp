package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public class GalleryCheckpoint {


    private final String name;

    public boolean isExpanded;

    public GalleryCheckpoint(String name) {
        this.name = name;
        isExpanded = false;
    }

    public String getName() {
        return name;
    }

}
