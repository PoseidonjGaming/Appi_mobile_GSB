package com.example.splashscreen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class FicheSqlHelper extends SQLiteOpenHelper {

    public static final String TABLE_FICHE = "FICHE";
    private static final String DATABASE_NAME = "bdamarionneau3.db";
    private static final int DATABASE_VERSION = 1;

    public static final String COLUMN_ID_FICHE = "ID_FICHE";
    public static final String COLUMN_MOIS = "MOIS";
    public static final String COLUMN_ID_VISIT = "ID_VISIT";
    public static final String COLUMN_ID_ETAT = "ID_ETAT";


    private static final String DATABASE_CREATE = "create table "
            + TABLE_FICHE + "(" + COLUMN_ID_FICHE
            + " Date primary key autoincrement, " + COLUMN_MOIS
            + " text not null, " + COLUMN_ID_VISIT
            + " text not null, " + COLUMN_ID_ETAT
            + ");";

    public FicheSqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(com.example.splashscreen.FicheSqlHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FICHE);
        onCreate(db);
    }


    /************************************************/
    /******** retourne la liste des Fiche         **/
    /************************************************/
    public ArrayList<Fiche> getLesSeries(String id) {
        ArrayList<Fiche> lesSesries = new ArrayList<Fiche>();
        String selectQuery = "SELECT " + COLUMN_MOIS + ", LIBELLE FROM " + TABLE_FICHE + " INNER JOIN ETAT ON " + TABLE_FICHE + "." + COLUMN_ID_ETAT + "= ETAT." + COLUMN_ID_ETAT + " WHERE " + COLUMN_ID_VISIT + " = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Fiche serie = new Fiche(
                        cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getInt(3)
                );
                lesSesries.add(serie);
            } while (cursor.moveToNext());
        }
        return lesSesries;
    }
    /************************************************/
    /******** retourne les Fiches                   **/
    /************************************************/
    public Fiche getFiche(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FICHE, new String[]{
                        COLUMN_ID_VISIT,
                        COLUMN_MOIS,
                        COLUMN_ID_VISIT,
                        COLUMN_ID_ETAT}, COLUMN_ID_VISIT + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Fiche fiche = new Fiche(
                cursor.getString(0),
                cursor.getInt(1),
                cursor.getInt(2),
                cursor.getInt(3));
        return fiche;
    }
}
