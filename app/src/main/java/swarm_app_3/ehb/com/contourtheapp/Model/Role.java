package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 9/01/2017.
 */

public class Role {
    private int roleId;
    private String naam;

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

    public Role() {
    }

    public Role(int roleId, String naam) {
        this.roleId = roleId;
        this.naam = naam;
    }
}
