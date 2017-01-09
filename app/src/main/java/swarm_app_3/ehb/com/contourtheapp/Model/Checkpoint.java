package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Checkpoint {
    private int checkpointId, volgorde, routeId;
    private double latitude, longtitude;

    public int getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(int checkpointId) {
        this.checkpointId = checkpointId;
    }

    public int getVolgorde() {
        return volgorde;
    }

    public void setVolgorde(int volgorde) {
        this.volgorde = volgorde;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public Checkpoint() {
    }

    public Checkpoint(int checkpointId, double latitude, double longtitude, int volgorde, int routeId) {
        this.checkpointId = checkpointId;
        this.volgorde = volgorde;
        this.routeId = routeId;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }
}
