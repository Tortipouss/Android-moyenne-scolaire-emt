package com.gallale.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.gallale.notes.models.Note;

import java.util.ArrayList;

public class NoteSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public static class noteTable implements BaseColumns{
        public static final String TABLE_NAME = "tb_note";
        public static final String COLUMN_NAME = "title_note";
        public static final String COLUMN_VALUE = "value_note";
        public static final String COLUMN_CATEGORY = "cat_note";

    }

    public NoteSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " +
                noteTable.TABLE_NAME + " ( " +
                noteTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                noteTable.COLUMN_NAME + " TEXT, " +
                noteTable.COLUMN_CATEGORY + " TEXT, " +
                noteTable.COLUMN_VALUE + " REAL" +
                ")";

        db.execSQL(SQL_CREATE_NOTES_TABLE);
        fillNoteTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + noteTable.TABLE_NAME);
        onCreate(db);
    }

    /*Remplit la table (de la BD) qui contiendra les questions avec des questions par défaut*/
    private void fillNoteTable(SQLiteDatabase db) {
        Note initial = new Note("INIT_BD", 0.5, null);
        addNote(initial, db);

        //region implements Base
        Note mod_math = new Note("Math", 0.5, "EPT");
        addNote(mod_math, db);
        Note mod_atelier = new Note("Atelier", 0.5, "EPT");
        addNote(mod_atelier, db);
        Note mod_anglais = new Note("Anglais", 0.5, "EPT");
        addNote(mod_anglais, db);
        Note mod_economie = new Note("Economie", 0.5, "EPT");
        addNote(mod_economie, db);
        Note mod_eduphys = new Note("Education Physique", 0.5, "EPT");
        addNote(mod_eduphys, db);
        Note mod_science = new Note("Science", 0.5, "EPT");
        addNote(mod_science, db);

        Note semestre1 = new Note("Premier semestre", 0.5, "EPT");
        addNote(semestre1, db);
        Note semestre2 = new Note("Deuxième semestre", 0.5, "EPT");
        addNote(semestre2, db);
        //endregion

        //region implements COMPOSANT
        Note divtec_inf_rbgp_value = new Note("divtec_inf_rbgp_value", 1.0, "COMPOSANT");
        addNote(divtec_inf_rbgp_value, db);
        //endregion

        //region implements MOYENNES
        Note divtec_inf_moy_tot_cg = new Note("divtec_inf_moy_tot_cg", 0.5, null);
        addNote(divtec_inf_moy_tot_cg, db);
        Note divtec_inf_moy_tot_atelier = new Note("divtec_inf_moy_tot_atelier", 0.5, null);
        addNote(divtec_inf_moy_tot_atelier, db);
        Note divtec_inf_moy_tot_ept = new Note("divtec_inf_moy_tot_ept", 0.5, null);
        addNote(divtec_inf_moy_tot_ept, db);
        Note divtec_inf_moy_tot_mod = new Note("divtec_inf_moy_tot_mod", 0.5, null);
        addNote(divtec_inf_moy_tot_mod, db);
        Note divtec_inf_moy_tot_mod_interEntreprise = new Note("divtec_inf_moy_tot_mod_interEntreprise", 0.5, null);
        addNote(divtec_inf_moy_tot_mod_interEntreprise, db);
        Note divtec_inf_moy_tot_mod_standard = new Note("divtec_inf_moy_tot_mod_standard", 0.5, null);
        addNote(divtec_inf_moy_tot_mod_standard, db);
        Note divtec_inf_moy_tot_tot = new Note("divtec_inf_moy_tot_tot", 0.5, null);
        addNote(divtec_inf_moy_tot_tot, db);
        //endregion

        // region implements MODULES
        Note divtec_inf_math_mi = new Note("MI", 0.5, "MOD");
        addNote(divtec_inf_math_mi, db);
        Note mod_100 = new Note("M100", 0.5, "MOD");
        addNote(mod_100, db);
        Note mod_101 = new Note("M101", 0.5, "MOD");
        addNote(mod_101, db);
        Note mod_104 = new Note("M104", 0.5, "MOD");
        addNote(mod_104, db);
        Note mod_105 = new Note("M105", 0.5, "MOD");
        addNote(mod_105, db);
        Note mod_114 = new Note("M114", 0.5, "MOD");
        addNote(mod_114, db);
        Note mod_115 = new Note("M115", 0.5, "MOD");
        addNote(mod_115, db);
        Note mod_117 = new Note("M117", 0.5, "MOD");
        addNote(mod_117, db);
        Note mod_122 = new Note("M122", 0.5, "MOD");
        addNote(mod_122, db);
        Note mod_123 = new Note("M123", 0.5, "MOD");
        addNote(mod_123, db);
        Note mod_124 = new Note("M124", 0.5, "MOD");
        addNote(mod_124, db);
        Note mod_127 = new Note("M127", 0.5, "MOD");
        addNote(mod_127, db);
        Note mod_129 = new Note("M129", 0.5, "MOD");
        addNote(mod_129, db);
        Note mod_133 = new Note("M133", 0.5, "MOD");
        addNote(mod_133, db);
        Note mod_140 = new Note("M140", 0.5, "MOD");
        addNote(mod_140, db);
        Note mod_143 = new Note("M143", 0.5, "MOD");
        addNote(mod_143, db);
        Note mod_145 = new Note("M145", 0.5, "MOD");
        addNote(mod_145, db);
        Note mod_151 = new Note("M151", 0.5, "MOD");
        addNote(mod_151, db);
        Note mod_153 = new Note("M153", 0.5, "MOD");
        addNote(mod_153, db);
        Note mod_159 = new Note("M159", 0.5, "MOD");
        addNote(mod_159, db);
        Note mod_182 = new Note("M182", 0.5, "MOD");
        addNote(mod_182, db);
        Note mod_214 = new Note("M214", 0.5, "MOD");
        addNote(mod_214, db);
        Note mod_226 = new Note("M226", 0.5, "MOD");
        addNote(mod_226, db);
        Note mod_302 = new Note("M302", 0.5, "MOD");
        addNote(mod_302, db);
        Note mod_304 = new Note("M304", 0.5, "MOD");
        addNote(mod_304, db);
        Note mod_305 = new Note("M305", 0.5, "MOD");
        addNote(mod_305, db);
        Note mod_306 = new Note("M306", 0.5, "MOD");
        addNote(mod_306, db);
        Note mod_340 = new Note("M340", 0.5, "MOD");
        addNote(mod_340, db);
        Note mod_403 = new Note("M403", 0.5, "MOD");
        addNote(mod_403, db);
        Note mod_404 = new Note("M404", 0.5, "MOD");
        addNote(mod_404, db);
        Note mod_431 = new Note("M431", 0.5, "MOD");
        addNote(mod_431, db);
        Note mod_437 = new Note("M437", 0.5, "MOD");
        addNote(mod_437, db);
        //endregion

        // region implements MATH
        //MATH
        Note divtec_inf_math_sem1 = new Note("divtec_inf_math_sem1", 0.5, "EPT");
        addNote(divtec_inf_math_sem1, db);
        Note divtec_inf_math_sem2 = new Note("divtec_inf_math_sem2", 0.5, "EPT");
        addNote(divtec_inf_math_sem2, db);
        Note divtec_inf_math_sem3 = new Note("divtec_inf_math_sem3", 0.5, "EPT");
        addNote(divtec_inf_math_sem3, db);
        Note divtec_inf_math_sem4 = new Note("divtec_inf_math_sem4", 0.5, "EPT");
        addNote(divtec_inf_math_sem4, db);
        Note divtec_inf_math_sem5 = new Note("divtec_inf_math_sem5", 0.5, "EPT");
        addNote(divtec_inf_math_sem5, db);
        Note divtec_inf_math_sem6 = new Note("divtec_inf_math_sem6", 0.5, "EPT");
        addNote(divtec_inf_math_sem6, db);
        Note divtec_inf_math_sem7 = new Note("divtec_inf_math_sem7", 0.5, "EPT");
        addNote(divtec_inf_math_sem7, db);
        Note divtec_inf_math_sem8 = new Note("divtec_inf_math_sem8", 0.5, "EPT");
        addNote(divtec_inf_math_sem8, db);
        Note divtec_inf_math_finale = new Note("divtec_inf_math_finale", 0.5, "EPT");
        addNote(divtec_inf_math_finale, db);
        // endregion implements

        // region implements SCIENCE
        Note divtec_inf_science_sem1 = new Note("divtec_inf_science_sem1", 0.5, "EPT");
        addNote(divtec_inf_science_sem1, db);
        Note divtec_inf_science_sem2 = new Note("divtec_inf_science_sem2", 0.5, "EPT");
        addNote(divtec_inf_science_sem2, db);
        Note divtec_inf_science_sem3 = new Note("divtec_inf_science_sem3", 0.5, "EPT");
        addNote(divtec_inf_science_sem3, db);
        Note divtec_inf_science_sem4 = new Note("divtec_inf_science_sem4", 0.5, "EPT");
        addNote(divtec_inf_science_sem4, db);
        Note divtec_inf_science_sem5 = new Note("divtec_inf_science_sem5", 0.5, "EPT");
        addNote(divtec_inf_science_sem5, db);
        Note divtec_inf_science_sem6 = new Note("divtec_inf_science_sem6", 0.5, "EPT");
        addNote(divtec_inf_science_sem6, db);
        Note divtec_inf_science_sem7 = new Note("divtec_inf_science_sem7", 0.5, "EPT");
        addNote(divtec_inf_science_sem7, db);
        Note divtec_inf_science_sem8 = new Note("divtec_inf_science_sem8", 0.5, "EPT");
        addNote(divtec_inf_science_sem8, db);
        Note divtec_inf_science_finale = new Note("divtec_inf_science_finale", 0.5, "EPT");
        addNote(divtec_inf_science_finale, db);
        // endregion implements

        // region implements ANGLAIS
        Note divtec_inf_anglais_sem1 = new Note("divtec_inf_anglais_sem1", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem1, db);
        Note divtec_inf_anglais_sem2 = new Note("divtec_inf_anglais_sem2", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem2, db);
        Note divtec_inf_anglais_sem3 = new Note("divtec_inf_anglais_sem3", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem3, db);
        Note divtec_inf_anglais_sem4 = new Note("divtec_inf_anglais_sem4", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem4, db);
        Note divtec_inf_anglais_sem5 = new Note("divtec_inf_anglais_sem5", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem5, db);
        Note divtec_inf_anglais_sem6 = new Note("divtec_inf_anglais_sem6", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem6, db);
        Note divtec_inf_anglais_sem7 = new Note("divtec_inf_anglais_sem7", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem7, db);
        Note divtec_inf_anglais_sem8 = new Note("divtec_inf_anglais_sem8", 0.5, "EPT");
        addNote(divtec_inf_anglais_sem8, db);
        Note divtec_inf_anglais_finale = new Note("divtec_inf_anglais_finale", 0.5, "EPT");
        addNote(divtec_inf_anglais_finale, db);
        // endregion implements

        // region implements ECONOMIE
        Note divtec_inf_economie_sem1 = new Note("divtec_inf_economie_sem1", 0.5, "EPT");
        addNote(divtec_inf_economie_sem1, db);
        Note divtec_inf_economie_sem2 = new Note("divtec_inf_economie_sem2", 0.5, "EPT");
        addNote(divtec_inf_economie_sem2, db);
        Note divtec_inf_economie_sem3 = new Note("divtec_inf_economie_sem3", 0.5, "EPT");
        addNote(divtec_inf_economie_sem3, db);
        Note divtec_inf_economie_sem4 = new Note("divtec_inf_economie_sem4", 0.5, "EPT");
        addNote(divtec_inf_economie_sem4, db);
        Note divtec_inf_economie_sem5 = new Note("divtec_inf_economie_sem5", 0.5, "EPT");
        addNote(divtec_inf_economie_sem5, db);
        Note divtec_inf_economie_sem6 = new Note("divtec_inf_economie_sem6", 0.5, "EPT");
        addNote(divtec_inf_economie_sem6, db);
        Note divtec_inf_economie_sem7 = new Note("divtec_inf_economie_sem7", 0.5, "EPT");
        addNote(divtec_inf_economie_sem7, db);
        Note divtec_inf_economie_sem8 = new Note("divtec_inf_economie_sem8", 0.5, "EPT");
        addNote(divtec_inf_economie_sem8, db);
        Note divtec_inf_economie_finale = new Note("divtec_inf_economie_finale", 0.5, "EPT");
        addNote(divtec_inf_economie_finale, db);
        // endregion implements

        // region implements EDU PHYSIQUE
        Note divtec_inf_edu_physique_sem1 = new Note("divtec_inf_edu_physique_sem1", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_edu_physique_sem2 = new Note("divtec_inf_edu_physique_sem2", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem2, db);
        Note divtec_inf_edu_physique_sem3 = new Note("divtec_inf_edu_physique_sem3", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem3, db);
        Note divtec_inf_edu_physique_sem4 = new Note("divtec_inf_edu_physique_sem4", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem4, db);
        Note divtec_inf_edu_physique_sem5 = new Note("divtec_inf_edu_physique_sem5", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem5, db);
        Note divtec_inf_edu_physique_sem6 = new Note("divtec_inf_edu_physique_sem6", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem6, db);
        Note divtec_inf_edu_physique_sem7 = new Note("divtec_inf_edu_physique_sem7", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem7, db);
        Note divtec_inf_edu_physique_sem8 = new Note("divtec_inf_edu_physique_sem8", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem8, db);
        Note divtec_inf_edu_physique_finale = new Note("divtec_inf_edu_physique_finale", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_finale, db);
        // endregion implements

        //region implements Société
        Note divtec_inf_societe_sem1 = new Note("divtec_inf_societe_sem1", 0.5, "EPT");
        addNote(divtec_inf_societe_sem1, db);
        Note divtec_inf_societe_sem2 = new Note("divtec_inf_societe_sem2", 0.5, "EPT");
        addNote(divtec_inf_societe_sem2, db);
        Note divtec_inf_societe_sem3 = new Note("divtec_inf_societe_sem3", 0.5, "EPT");
        addNote(divtec_inf_societe_sem3, db);
        Note divtec_inf_societe_sem4 = new Note("divtec_inf_societe_sem4", 0.5, "EPT");
        addNote(divtec_inf_societe_sem4, db);
        Note divtec_inf_societe_sem5 = new Note("divtec_inf_societe_sem5", 0.5, "EPT");
        addNote(divtec_inf_societe_sem5, db);
        Note divtec_inf_societe_sem6 = new Note("divtec_inf_societe_sem6", 0.5, "EPT");
        addNote(divtec_inf_societe_sem6, db);
        Note divtec_inf_societe_sem7 = new Note("divtec_inf_societe_sem7", 0.5, "EPT");
        addNote(divtec_inf_societe_sem7, db);
        Note divtec_inf_societe_sem8 = new Note("divtec_inf_societe_sem8", 0.5, "EPT");
        addNote(divtec_inf_societe_sem8, db);
        //endregion

        // region implements Langue et Comm
        Note divtec_inf_langueEtComm_sem1 = new Note("divtec_inf_langueEtComm_sem1", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem2 = new Note("divtec_inf_langueEtComm_sem2", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem3 = new Note("divtec_inf_langueEtComm_sem3", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem4 = new Note("divtec_inf_langueEtComm_sem4", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem5 = new Note("divtec_inf_langueEtComm_sem5", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem6 = new Note("divtec_inf_langueEtComm_sem6", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem7 = new Note("divtec_inf_langueEtComm_sem7", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        Note divtec_inf_langueEtComm_sem8 = new Note("divtec_inf_langueEtComm_sem8", 0.5, "EPT");
        addNote(divtec_inf_edu_physique_sem1, db);
        //endregion

        //region implements ATELIER
        Note divtec_inf_atelier_sem1 = new Note("divtec_inf_atelier_sem1", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem1, db);
        Note divtec_inf_atelier_sem2 = new Note("divtec_inf_atelier_sem2", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem2, db);
        Note divtec_inf_atelier_sem3 = new Note("divtec_inf_atelier_sem3", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem3, db);
        Note divtec_inf_atelier_sem4 = new Note("divtec_inf_atelier_sem4", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem4, db);
        Note divtec_inf_atelier_sem5 = new Note("divtec_inf_atelier_sem5", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem5, db);
        Note divtec_inf_atelier_sem6 = new Note("divtec_inf_atelier_sem6", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem6, db);
        Note divtec_inf_atelier_sem7 = new Note("divtec_inf_atelier_sem7", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem7, db);
        Note divtec_inf_atelier_sem8 = new Note("divtec_inf_atelier_sem8", 0.5, "ATE");
        addNote(divtec_inf_atelier_sem8, db);
        //endregion
    }

    // Utilisé pout initialiser la BD
    public void addNote(Note note, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(noteTable.COLUMN_NAME, note.getNote());
        cv.put(noteTable.COLUMN_VALUE, note.getValue());
        cv.put(noteTable.COLUMN_CATEGORY, note.getCategory());
        db.insert(noteTable.TABLE_NAME, null, cv);
    }

    // Insere une note dans la BD
    public void addNote(Note note) {
        ContentValues cv = new ContentValues();
        cv.put(noteTable.COLUMN_NAME, note.getNote());
        cv.put(noteTable.COLUMN_VALUE, note.getValue());
        cv.put(noteTable.COLUMN_CATEGORY, note.getCategory());
        db.insert(noteTable.TABLE_NAME, null, cv);
    }

    // Recupere toutes les notes de la BD
    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> noteList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + noteTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNote(c.getString(c.getColumnIndex(noteTable.COLUMN_NAME)));
                note.setValue(c.getDouble(c.getColumnIndex(noteTable.COLUMN_VALUE)));
                note.setCategory(c.getString(c.getColumnIndex(noteTable.COLUMN_CATEGORY)));
                noteList.add(note);
            } while (c.moveToNext());
        }

        c.close();
        return noteList;
    }

    public ArrayList<Note> getAllNotesEpt() {
        ArrayList<Note> noteList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + noteTable.TABLE_NAME + " WHERE " + noteTable.COLUMN_CATEGORY + " LIKE " + "'EPT'", null);
        if (c.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNote(c.getString(c.getColumnIndex(noteTable.COLUMN_NAME)));
                note.setValue(c.getDouble(c.getColumnIndex(noteTable.COLUMN_VALUE)));
                note.setCategory(c.getString(c.getColumnIndex(noteTable.COLUMN_CATEGORY)));
                noteList.add(note);
            } while (c.moveToNext());
        }

        c.close();
        return noteList;
    }

    public ArrayList<Note> getAllNotesAtelier() {
        ArrayList<Note> noteList = new ArrayList<>();
        db = getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM " + noteTable.TABLE_NAME + " WHERE " + noteTable.COLUMN_CATEGORY + " LIKE " + "'ATE'", null);
        if (c.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNote(c.getString(c.getColumnIndex(noteTable.COLUMN_NAME)));
                note.setValue(c.getDouble(c.getColumnIndex(noteTable.COLUMN_VALUE)));
                note.setCategory(c.getString(c.getColumnIndex(noteTable.COLUMN_CATEGORY)));
                noteList.add(note);
            } while (c.moveToNext());
        }

        c.close();
        return noteList;
    }

    public ArrayList<Note> getAllNotesModules() {
        ArrayList<Note> noteList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + noteTable.TABLE_NAME + " WHERE " + noteTable.COLUMN_CATEGORY + " LIKE " + "'MOD'", null);
        if (c.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNote(c.getString(c.getColumnIndex(noteTable.COLUMN_NAME)));
                note.setValue(c.getDouble(c.getColumnIndex(noteTable.COLUMN_VALUE)));
                note.setCategory(c.getString(c.getColumnIndex(noteTable.COLUMN_CATEGORY)));
                noteList.add(note);
            } while (c.moveToNext());
        }

        c.close();
        return noteList;
    }

    public Double getNoteValueByName(String nom){
        db = getReadableDatabase();
        Double finalValue = 0.5;
        Cursor c = db.rawQuery("SELECT * FROM " + noteTable.TABLE_NAME + " WHERE " + noteTable.COLUMN_NAME + " LIKE " + "'" + nom + "'", null);
        if (c.moveToFirst()) {
            do {
                finalValue = c.getDouble(c.getColumnIndex(noteTable.COLUMN_VALUE));
            } while (c.moveToNext());
        }
        c.close();

        return finalValue;
    }

    public Note getNoteByName(String name){
        db = getReadableDatabase();
        Note note = new Note();
        Cursor c = db.rawQuery("SELECT * FROM " + noteTable.TABLE_NAME + " WHERE " + noteTable.COLUMN_NAME + " LIKE " + "'" + name + "'", null);
        if (c.moveToFirst()) {
            do {
                note.setNote(c.getString(c.getColumnIndex(noteTable.COLUMN_NAME)));
                note.setValue(c.getDouble(c.getColumnIndex(noteTable.COLUMN_VALUE)));
                note.setCategory(c.getString(c.getColumnIndex(noteTable.COLUMN_CATEGORY)));
            } while (c.moveToNext());
        }
        c.close();

        return note;
    }

    public void deleteDB(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + noteTable.TABLE_NAME);
        onCreate(db);
    }


    public void updateNoteValueByName(String name, Double newValue){
        db = getWritableDatabase();

        ContentValues newValues = new ContentValues();
        newValues.put(noteTable.COLUMN_VALUE, newValue);

        db.update(noteTable.TABLE_NAME, newValues, noteTable.COLUMN_NAME + " LIKE " + "'" + name + "'", null);
    }
}
