package com.ifsc.blocodenotassqllite.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class NotaDAO {
    Context mContext;
    SQLiteDatabase database;

    public NotaDAO(Context mContext) {
        this.mContext = mContext;
        database = mContext.openOrCreateDatabase("dbnotas", Context.MODE_PRIVATE, null);

        database.execSQL("CREATE TABLE IF NOT EXISTS notas" +
                "  (id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " titulo varchar," +
                " texto varchar)");
    }

    public Nota insertNota(Nota nota) {
        if (nota.getId() == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo", nota.getTitulo());
            contentValues.put("texto", nota.getTexto());
            long i = database.insert("notas", null, contentValues);
            nota.setId((int) i);
        }
        return nota;
    }


    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = database.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> notas = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Nota nota = new Nota(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            notas.add(nota);
            cursor.moveToNext();

        }

        return notas;

    }

    public Nota buscaNota(Integer id) {
        Cursor cursor = this.database.rawQuery("SELECT * FROM notas WHERE id=?",new String [] {Integer.toString(id)});
        cursor.moveToFirst();
        return new Nota( cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
        );
    }

    public boolean atualizaNota(Nota nota) {
        if (nota.getId() != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo", nota.getTitulo());
            contentValues.put("texto", nota.getTexto());
            database.update("notas", contentValues, "id=?", new String[]{Integer.toString(nota.getId())});
            return  true;
        }
        return  false;
    }

    public boolean removeNota(Nota nota) {
        if (database.delete("notas", "id=?", new String[]{Integer.toString(nota.getId())}) > 0) {
            return true;
        }else {
            return false;
        }
    }
}
