package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Userkenmerkwaarde {
    private int userKenmerkWaardeId, kenmerkWaardeId, userId;

    public int getUserKenmerkWaardeId() {
        return userKenmerkWaardeId;
    }

    public void setUserKenmerkWaardeId(int userKenmerkWaardeId) {
        this.userKenmerkWaardeId = userKenmerkWaardeId;
    }

    public int getKenmerkWaardeId() {
        return kenmerkWaardeId;
    }

    public void setKenmerkWaardeId(int kenmerkWaardeId) {
        this.kenmerkWaardeId = kenmerkWaardeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Userkenmerkwaarde() {
    }

    public Userkenmerkwaarde(int userKenmerkWaardeId, int kenmerkWaardeId, int userId) {
        this.userKenmerkWaardeId = userKenmerkWaardeId;
        this.kenmerkWaardeId = kenmerkWaardeId;
        this.userId = userId;
    }
}
