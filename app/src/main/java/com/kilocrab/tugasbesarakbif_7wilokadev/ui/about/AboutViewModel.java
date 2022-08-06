//tanggal pengerjaan : 05/08/2022
//nim                : 10119258
//nama               : Mochamad Adi Maulia Rahman
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.ui.about;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kilocrab.tugasbesarakbif_7wilokadev.R;
import com.kilocrab.tugasbesarakbif_7wilokadev.model.AboutModel;

import java.util.List;

public class AboutViewModel extends RecyclerView.Adapter<AboutViewModel.ViewHolder> {

    List<AboutModel> aboutViewModelList;

    public AboutViewModel(List<AboutModel> aboutViewModelList) {
        this.aboutViewModelList = aboutViewModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AboutModel aboutViewModel = aboutViewModelList.get(position);
        holder.judul.setText(aboutViewModel.judul);
        holder.deskripsi.setText(aboutViewModel.deskripsi);
    }

    @Override
    public int getItemCount() {
        if(aboutViewModelList != null) return aboutViewModelList.size();
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul, deskripsi;

        public ViewHolder(View view) {
            super(view);

            judul = view.findViewById(R.id.judul_about);
            deskripsi = view.findViewById(R.id.deskripsi_about);
        }
    }
}