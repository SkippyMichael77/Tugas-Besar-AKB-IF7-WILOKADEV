//tanggal pengerjaan : 06/08/2022
//nim                : 10119283
//nama               : Rahmatullah Rizki
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.ui.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MapViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}