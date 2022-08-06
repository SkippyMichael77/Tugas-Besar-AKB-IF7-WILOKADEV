//tanggal pengerjaan : 06/08/2022
//nim                : 10119265
//nama               : Ismayani Setyaningrum
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.model;

public class WisataModel {
    public int id;
    public String image;
    public String nama_tempat;
    public String lokasi;
    public String deskripsi_tempat;
    public String lat;
    public String lng;

    public WisataModel(){}

    public WisataModel(int id, String image, String nama_tempat, String lokasi,
                       String deskripsi_tempat, String lat, String lng){
        this.id = id;
        this.image = image;
        this.nama_tempat = nama_tempat;
        this.lokasi = lokasi;
        this.deskripsi_tempat = deskripsi_tempat;
        this.lat = lat;
        this.lng = lng;
    }
}
