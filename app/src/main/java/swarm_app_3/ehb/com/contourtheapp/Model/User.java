package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class User {
    private int userId, roleId;
    private String naam, voornaam, imeiNummer;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getImeiNummer() {
        return imeiNummer;
    }

    public void setImeiNummer(String imeiNummer) {
        this.imeiNummer = imeiNummer;
    }



    public User() {
    }

    public User(int userId,  String naam, String voornaam, String imeiNummer,int roleId) {
        this.userId = userId;
        this.roleId = roleId;
        this.naam = naam;
        this.voornaam = voornaam;

        this.imeiNummer = imeiNummer;
    }
}
