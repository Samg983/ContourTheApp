package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Inschrijving {

    private int inschrijvingsId, routeId, userId;
    private String datum;

    public int getInschrijvingsId() {
        return inschrijvingsId;
    }

    public void setInschrijvingsId(int inschrijvingsId) {
        this.inschrijvingsId = inschrijvingsId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Inschrijving() {
    }

    public Inschrijving(int inschrijvingsId, String datum, int routeId, int userId) {
        this.inschrijvingsId = inschrijvingsId;
        this.routeId = routeId;
        this.userId = userId;
        this.datum = datum;
    }

}
