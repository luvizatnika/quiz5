package com.luvizatnika1501512.utsmobprog.quiz51501512;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView nama, alamat;
    ArrayList<DbMahasiswa.Mahasiswa> alMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (TextView) findViewById(R.id.nama);
        alamat = (TextView) findViewById(R.id.alamat);
    }

    DbMahasiswa dbkampus;

    public void onClick(View v){
        dbkampus = new DbMahasiswa(getApplicationContext());
        dbkampus.open();
        dbkampus.insertMahasiswa("Luvi", "Linggasari");

        ArrayList<DbMahasiswa.Mahasiswa> alMhs = dbkampus.getAllMahasiswa();

        DbMahasiswa.Mahasiswa m = dbkampus.getMahasiswa("Luvi");
        Toast.makeText(getApplicationContext(),
                String.format("nama : %s ; alamat: %s",m.nama,m.alamat),Toast.LENGTH_LONG).show();

        for (DbMahasiswa.Mahasiswa mhs:alMhs) {
            Toast.makeText(getApplicationContext(),
                    String.format("nama: %s ; alamat: %s",mhs.nama,mhs.alamat), Toast.LENGTH_SHORT).show();
            String name = mhs.nama;
            String jumlah = mhs.alamat;
            nama.setText(name);
            alamat.setText(jumlah);

        }
    }


}
