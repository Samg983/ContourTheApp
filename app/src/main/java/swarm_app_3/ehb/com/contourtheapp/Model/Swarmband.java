package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Swarmband {
    private int swarmbandId, hartslag;
    private double snelheid, lichaamstemperatuur;

    public int getSwarmbandId() {
        return swarmbandId;
    }

    public void setSwarmbandId(int swarmbandId) {
        this.swarmbandId = swarmbandId;
    }

    public int getHartslag() {
        return hartslag;
    }

    public void setHartslag(int hartslag) {
        this.hartslag = hartslag;
    }

    public double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(double snelheid) {
        this.snelheid = snelheid;
    }

    public double getLichaamstemperatuur() {
        return lichaamstemperatuur;
    }

    public void setLichaamstemperatuur(double lichaamstemperatuur) {
        this.lichaamstemperatuur = lichaamstemperatuur;
    }

    public Swarmband() {
    }

    public Swarmband(int swarmbandId, double snelheid, int hartslag,  double lichaamstemperatuur) {
        this.swarmbandId = swarmbandId;
        this.hartslag = hartslag;
        this.snelheid = snelheid;
        this.lichaamstemperatuur = lichaamstemperatuur;
    }
}
