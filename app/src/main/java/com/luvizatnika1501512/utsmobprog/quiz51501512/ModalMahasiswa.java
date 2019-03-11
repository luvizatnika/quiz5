package com.luvizatnika1501512.utsmobprog.quiz51501512;

public class ModalMahasiswa {

    private String _id, _nama, _alamat;

    public ModalMahasiswa (String id, String nama, String alamat){
        this._id = id;
        this._nama = nama;
        this._alamat = alamat;
    }

    public ModalMahasiswa (){

    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_nama() {
        return _nama;
    }

    public void set_alamat(String _alamat) { this._alamat = _alamat; }

    public String get_alamat() { return _alamat; }



}
