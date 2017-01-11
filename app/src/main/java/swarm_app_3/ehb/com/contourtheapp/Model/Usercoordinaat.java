package swarm_app_3.ehb.com.contourtheapp.Model;

import java.sql.Timestamp;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Usercoordinaat {
    private int usercoordinaatId, inschrijvingsId;
    private double latitude, longtitude;
    private String timestamp;

    public int getUsercoordinaatId() {
        return usercoordinaatId;
    }

    public void setUsercoordinaatId(int usercoordinaatId) {
        this.usercoordinaatId = usercoordinaatId;
    }

    public int getInschrijvingsId() {
        return inschrijvingsId;
    }

    public void setInschrijvingsId(int inschrijvingsId) {
        this.inschrijvingsId = inschrijvingsId;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Usercoordinaat() {
    }

    public Usercoordinaat(int usercoordinaatId, double latitude, double longtitude, String timestamp, int inschrijvingsId) {
        this.usercoordinaatId = usercoordinaatId;
        this.inschrijvingsId = inschrijvingsId;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Usercoordinaat " + this.getLatitude();
    }
}
