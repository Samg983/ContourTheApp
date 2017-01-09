package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Kenmerk {

    private int kenmerkId;
    private String naam;

    public int getKenmerkId() {
        return kenmerkId;
    }

    public void setKenmerkId(int kenmerkId) {
        this.kenmerkId = kenmerkId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Kenmerk(){

    }

    public Kenmerk(int kenmerkId, String naam) {
        this.kenmerkId = kenmerkId;
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Kenmerk{" +
                "kenmerkId=" + kenmerkId +
                ", naam='" + naam + '\'' +
                '}';
    }
}
