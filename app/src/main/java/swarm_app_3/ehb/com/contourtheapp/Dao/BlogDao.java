package swarm_app_3.ehb.com.contourtheapp.Dao;

import android.database.Cursor;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Model.Blog;

/**
 * Created by Bram Schrooyen on 20/12/2016.
 */

public class BlogDao {

    public static ArrayList<Blog> getWorks() {
        ArrayList<Blog> resultaat = new ArrayList<Blog>();
        Cursor mijnCursor = getWorksCursor();
        if (mijnCursor != null) {
            while (mijnCursor.moveToNext()) {
                Blog huidigWork = converteerHuidigeRijNaarObject(mijnCursor);
                resultaat.add(huidigWork);
            }
        }

        return resultaat;
    }

    public static Cursor getWorksCursor() {
        return Database.voerSqlLeesActieUit("SELECT * from Work");
    }

    public static Blog getWorkById(int id) {
        Blog resultaat = null;

        Cursor mijnCursor = getWorkByIdCursor(id);
        if (mijnCursor != null) {
            mijnCursor.moveToFirst();
            resultaat = converteerHuidigeRijNaarObject(mijnCursor);
        }

        return resultaat;
    }

    public static Cursor getWorkByIdCursor(int id){
        return Database.voerSqlLeesActieUit("SELECT * from Work where workId = ?", new String[] { Integer.toString(id) });
    }

    public static void voegWorkToe(Blog newWork) {
        Database.voerSqlSchrijfActieUit("INSERT INTO Work (title, artist, place, description, date, image) VALUES (?,?,?)", new Object[] { newWork.getTitle(), newWork.getArtist(), newWork.getPlace(), newWork.getDescription(), newWork.getDate(), newWork.getImageResource() });
    }

    public static void updateWork(Blog newWork) {
        Database.voerSqlSchrijfActieUit("UPDATE Work SET title = ?, artist = ?, place = ?, description = ?, date = ?, image = ?,  WHERE workId = ?", new Object[] { newWork.getTitle(), newWork.getArtist(), newWork.getPlace(), newWork.getDescription(), newWork.getDate(), newWork.getImageResource(), newWork.getWorkId() });
    }

    public static void verwijderWork(int workId) {
        Database.voerSqlSchrijfActieUit("DELETE FROM Work WHERE workId = ?", new Object[] { workId });
    }

    private static Blog converteerHuidigeRijNaarObject(Cursor mijnCursor) {
        return new Blog(mijnCursor.getInt(mijnCursor.getColumnIndex("workId")), mijnCursor.getString(mijnCursor.getColumnIndex("title")), mijnCursor.getString(mijnCursor.getColumnIndex("artist")), mijnCursor.getString(mijnCursor.getColumnIndex("place")), mijnCursor.getString(mijnCursor.getColumnIndex("description")), mijnCursor.getInt(mijnCursor.getColumnIndex("date")), mijnCursor.getInt(mijnCursor.getColumnIndex("image")));
    }

}
