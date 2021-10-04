package com.example.splashscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class VisiteurSqlHelper extends SQLiteOpenHelper {

    public static final String TABLE_VISITEUR = "VISITEUR";
    private static final String DATABASE_NAME = "bdamarionneau3.db";
    private static final int DATABASE_VERSION = 1;

    public static final String COLUMN_ID_VISIT = "ID_VISIT";
    public static final String COLUMN_NOM="NOM";
    public static final String COLUMN_PRENOM="PRENOM";
    public static final String COLUMN_LOGIN="LOGIN";
    public static final String COLUMN_MDP="premiereDiffusion";
    public static final String COLUMN_ADRESSE="ADRESSE";
    public static final String COLUMN_CP="CP";
    public static final String COLUMN_VILLE="VILLE";



    private static final String DATABASE_CREATE = "create table "
            + TABLE_VISITEUR + "("+COLUMN_ID_VISIT+ " integer primary key autoincrement, "
            + " text not null, " + COLUMN_NOM
            + " text not null, " + COLUMN_PRENOM
            + " text not null, " + COLUMN_LOGIN
            + " text not null, " + COLUMN_MDP
            + " text not null, " + COLUMN_ADRESSE
            + " text not null, " + COLUMN_CP
            + " text not null, " + COLUMN_VILLE
            + ");";

    public VisiteurSqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(VisiteurSqlHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITEUR);
        onCreate(db);
    }


    /************************************************/
    /******** retourne la liste des series         **/
    /************************************************/
    public ArrayList<Visiteur> getLesSeries() {
        ArrayList<Visiteur> lesSesries = new ArrayList<Visiteur>();
        String selectQuery = "SELECT  * FROM " + TABLE_VISITEUR;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Visiteur visiteur = new Visiteur(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7));
                lesSesries.add(visiteur);
            } while (cursor.moveToNext());
        }
        return lesSesries;
    }
    /************************************************/
    /******** retourne une serie                   **/
    /************************************************/
    public Visiteur getVisiteur(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_VISITEUR, new String[] {
                        COLUMN_ID_VISIT,
                        COLUMN_NOM,
                        COLUMN_PRENOM,
                        COLUMN_LOGIN,
                        COLUMN_MDP,
                        COLUMN_ADRESSE,
                        COLUMN_CP,
                        COLUMN_VILLE}, COLUMN_LOGIN + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Visiteur visiteur = new Visiteur(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7));
        return visiteur;
    }

}
