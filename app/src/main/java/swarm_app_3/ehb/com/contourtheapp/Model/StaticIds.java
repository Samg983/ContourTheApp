package swarm_app_3.ehb.com.contourtheapp.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SamGoeman on 11/01/2017.
 */

public class StaticIds {
    public static int userId;
    public static int inschrijvingsId;
    public static boolean alreadySubscribed = false;


    public static void setSharedPreferences(Context context, int userId, int inschrijvingsId, boolean alreadySubscribed) {
        SharedPreferences sp = context.getSharedPreferences("PREFERENCES", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("userId", userId);
        editor.putInt("inschrijvingsId", inschrijvingsId);
        editor.putBoolean("alreadySubscribed", alreadySubscribed);
        editor.commit();
    }

    public static int getUserIdSharedPreferences(Context context){
        return context.getSharedPreferences("PREFERENCES", context.MODE_PRIVATE).getInt("userId", 0);
    }

    public static int getInschrijvingsIdSharedPreferences(Context context){
        return context.getSharedPreferences("PREFERENCES", context.MODE_PRIVATE).getInt("inschrijvingsId", 0);
    }

    public static Boolean getAlreadySubscribedSharedPreferences(Context context){
        return context.getSharedPreferences("PREFERENCES", context.MODE_PRIVATE).getBoolean("alreadySubscribed", false);
    }
}
