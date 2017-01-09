package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Photo {
    private int photoId, checkpointId;
    private byte[] sourcePhoto;

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

    public byte[] getSourcePhoto() {
        return sourcePhoto;
    }

    public void setSourcePhoto(byte[] sourcePhoto) {
        this.sourcePhoto = sourcePhoto;
    }

    public Photo() {
    }

    public Photo(int photoId,  byte[] sourcePhoto, int checkpointId) {
        this.photoId = photoId;
        this.checkpointId = checkpointId;
        this.sourcePhoto = sourcePhoto;
    }
}
