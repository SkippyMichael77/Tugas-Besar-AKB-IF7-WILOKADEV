//tanggal pengerjaan : 06/08/2022
//nim                : 10119265
//nama               : Ismayani Setyaningrum
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.controller;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class WisataController {
    DatabaseReference databaseReference;

    public WisataController(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
    public Query get(){
        return databaseReference.child("ListWisata");
    }
}
