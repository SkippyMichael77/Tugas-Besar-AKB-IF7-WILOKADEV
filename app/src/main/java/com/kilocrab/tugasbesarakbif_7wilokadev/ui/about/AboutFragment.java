//tanggal pengerjaan : 05/08/2022
//nim                : 10119258
//nama               : Mochamad Adi Maulia Rahman
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.kilocrab.tugasbesarakbif_7wilokadev.R;
import com.kilocrab.tugasbesarakbif_7wilokadev.model.AboutModel;
import com.kilocrab.tugasbesarakbif_7wilokadev.databinding.FragmentAboutBinding;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager2 viewPager2;
    private List<AboutModel> aboutList;
    private FragmentAboutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        viewPager2 = view.findViewById(R.id.viewpager);
        aboutList = new ArrayList<>();

        String[] judul = {"ABOUT APP","TUJUAN PERANCANGAN"};
        String[] desc = {"Wilokadev merupakan sebuah aplikasi yang dapat memberikan informasi terkait lokasi realtime pengguna serta tempat wisata populer dibandung dan sekitarnya.\n"+
        "1. Dengan wilokadev, kamu bisa melihat lokasi terkini mu lhoo!\n" + "2. Lihat lokasi wisata populer dibandung dan sekitarnya dengan mudah",
                "Tujuan perancangan dari aplikasi ini ditujukan untuk memenuhi tugas dari matakuliah AKB dengan dosen pengampu Alif Finandhita, S.Kom, M.T" };

        for (int i=0; i < judul.length; i++){
            AboutModel item = new AboutModel(judul[i], desc[i]);
            aboutList.add(item);
        }
        AboutViewModel adapter = new AboutViewModel(aboutList);

        viewPager2.setAdapter(adapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}