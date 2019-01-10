package lo52.utbm.f1_levier;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getDatas() {

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Nom_participant, ech_participant, temps_sprint1 FROM participant", null);

        if (cursor.moveToFirst()){
            do {
                // Passing values
                String Nom_participant = cursor.getString(0);
                String ech_participant = cursor.getString(1);
                String temps_sprint1 = cursor.getString(2);



                // Do something Here with values

            } while(cursor.moveToNext());
        }
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            list.add(cursor.getString(0));
//            cursor.moveToNext();
//        }
        cursor.close();
        return list;
    }

    public List<String> getTeams() {

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT nom_equipe FROM equipe " ,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
//            list.add(cursor.getString(1));
//            list.get(1);
//            list.add(1,cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
