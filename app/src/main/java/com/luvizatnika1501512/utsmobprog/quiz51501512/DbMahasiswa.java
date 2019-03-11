package com.luvizatnika1501512.utsmobprog.quiz51501512;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbMahasiswa {

    public static class Mahasiswa{
        public String nama;
        public String alamat;



    }

    private SQLiteDatabase db;
    private final DatabaseHandler dbHandler;



    public DbMahasiswa(Context c) {
        dbHandler =  new DatabaseHandler(c);
    }

    public void open() {
        db = dbHandler.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertMahasiswa(String nama, String alamat) {
        ContentValues newValues = new ContentValues();
        newValues.put("NAMA", nama);
        newValues.put("ALAMAT", alamat);
        return db.insert("MAHASISWA", null, newValues);
    }

    //ambil data mahasiswa berdasarkan nama
    public Mahasiswa getMahasiswa(String nama) {
        Cursor cur = null;
        Mahasiswa M = new Mahasiswa();

        //kolom yang diambil
        String[] cols = new String [] {"ID", "NAMA", "ALAMAT"};
        //parameter, akan mengganti ? pada NAMA=?
        String[] param  = {nama};

        cur = db.query("MAHASISWA",cols,"NAMA=?",param,null,null,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            M.nama = cur.getString(1);
            M.alamat = cur.getString(2);
        }
        cur.close();
        return M;
    }

    public ArrayList<Mahasiswa> getAllMahasiswa() {
        Cursor cur = null;
        ArrayList<Mahasiswa> out = new ArrayList<>();
        cur = db.rawQuery("SELECT nama,alamat FROM Mahasiswa Limit 10", null);
        if (cur.moveToFirst()) {
            do {
                Mahasiswa mhs = new Mahasiswa();
                mhs.nama = cur.getString(0);
                mhs.alamat = cur.getString(1);
                out.add(mhs);
            } while (cur.moveToNext());
        }
        cur.close();
        return out;
    }
}
