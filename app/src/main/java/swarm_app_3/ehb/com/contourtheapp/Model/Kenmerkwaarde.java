package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Kenmerkwaarde {
    private int kenmerkWaardeId, kenmerkId;
    private String kenmerkWaarde;

    public int getKenmerkWaardeId() {
        return kenmerkWaardeId;
    }

    public void setKenmerkWaardeId(int kenmerkWaardeId) {
        this.kenmerkWaardeId = kenmerkWaardeId;
    }

    public int getKenmerkId() {
        return kenmerkId;
    }

    public void setKenmerkId(int kenmerkId) {
        this.kenmerkId = kenmerkId;
    }

    public String getKenmerkWaarde() {
        return kenmerkWaarde;
    }

    public void setKenmerkWaarde(String kenmerkWaarde) {
        this.kenmerkWaarde = kenmerkWaarde;
    }

    public Kenmerkwaarde() {
    }

    public Kenmerkwaarde(int kenmerkWaardeId, String kenmerkWaarde, int kenmerkId) {
        this.kenmerkWaardeId = kenmerkWaardeId;

        this.kenmerkWaarde = kenmerkWaarde;
        this.kenmerkId = kenmerkId;
    }
}
