package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public class GalleryPhoto {

    public int imgGallery;
    public int id;

    public GalleryPhoto(int imgGallery, int id) {
        this.imgGallery = imgGallery;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getImgGallery() {
        return imgGallery;
    }

}
