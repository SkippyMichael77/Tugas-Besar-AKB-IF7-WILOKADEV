//tanggal pengerjaan : 06/08/2022
//nim                : 10119269
//nama               : Zuhair Rasyid Wafi
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.kilocrab.tugasbesarakbif_7wilokadev.R;
import com.kilocrab.tugasbesarakbif_7wilokadev.controller.WisataController;
import com.kilocrab.tugasbesarakbif_7wilokadev.databinding.FragmentHomeBinding;
import com.kilocrab.tugasbesarakbif_7wilokadev.model.WisataModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private WisataController database = new WisataController();
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    ArrayList<WisataModel> ListWisata = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.home_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getData();

        return view;
    }

    private void getData() {
        ValueEventListener valueEventListener = database.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot item : snapshot.getChildren()) {
                    WisataModel wisata = item.getValue(WisataModel.class);
                    ListWisata.add(wisata);
                }
                System.out.println(ListWisata.size());

                homeViewModel = new HomeViewModel(getActivity(), ListWisata);
                recyclerView.setAdapter(homeViewModel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}