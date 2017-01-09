package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public class Photo {

    private int photoId, checkpointId;
    //private byte[] sourcePhoto;
    private int sourcePhoto;

    public Photo() {
    }


    public Photo(int photoId, int sourcePhoto, int checkpointId) {
        this.photoId = photoId;
        this.sourcePhoto = sourcePhoto;
        this.checkpointId = checkpointId;
    }

    /*public Photo(int photoId, byte[] sourcePhoto, int checkpointId) { -> constructor indien blob werkt
        this.photoId = photoId;
        this.checkpointId = checkpointId;
        this.sourcePhoto = sourcePhoto;
    }*/

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(int checkpointId) {
        this.checkpointId = checkpointId;
    }

    public int getSourcePhoto() {return sourcePhoto;}

    public void setSourcePhoto(){this.sourcePhoto = sourcePhoto;}

    //public byte[] getSourcePhoto() {return sourcePhoto;} -> gebruiken als blob in orde is?

    //public void setSourcePhoto(byte[] sourcePhoto) {this.sourcePhoto = sourcePhoto;} -> gebruiken als blob in orde is?



    //VORIGE CODE (BACKUP)

    //public int imgGallery;
    //public int id;

     /*public int getId() {
        return id;
    }*/

    /*public int getImgGallery() {
        return imgGallery;
    }*/

    /*public Photo(int photoId, int sourcePhoto) {
        this.photoId = photoId;
        this.sourcePhoto = sourcePhoto;
    }*/

}
