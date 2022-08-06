//tanggal pengerjaan : 06/08/2022
//nim                : 10119269
//nama               : Zuhair Rasyid Wafi
//kelas              : IF7
package com.kilocrab.tugasbesarakbif_7wilokadev.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kilocrab.tugasbesarakbif_7wilokadev.R;
import com.kilocrab.tugasbesarakbif_7wilokadev.model.WisataModel;
import com.kilocrab.tugasbesarakbif_7wilokadev.ui.map.MapsActivity;

import java.util.List;

public class HomeViewModel extends RecyclerView.Adapter<HomeViewModel.HomeViewHolder> {

    private Context context;
    private Activity activity;
    private List<WisataModel> listWisata;

    public HomeViewModel(Activity activity, List<WisataModel> listWisata) {
        this.activity = activity;
        this.listWisata = listWisata;
    }

    @NonNull
    @Override
    public HomeViewModel.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.tampilan_wisata, parent, false);
        context = parent.getContext();
        return new HomeViewModel.HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        final WisataModel data = listWisata.get(position);
        holder.namatempat.setText(String.valueOf(data.nama_tempat));
        holder.lokasitempat.setText(String.valueOf(data.lokasi));
        holder.deskripsitempat.setText(String.valueOf(data.deskripsi_tempat));
        Glide.with(context).load(data.image).into(holder.image);

        holder.tampilan_wisata.setOnClickListener(view -> {
            Intent intent = new Intent(activity, MapsActivity.class);
            intent.putExtra("namatempat", String.valueOf(data.nama_tempat));
            intent.putExtra("deskripsitempat", String.valueOf(data.deskripsi_tempat));
            intent.putExtra("lat", String.valueOf(data.lat));
            intent.putExtra("lng", String.valueOf(data.lng));
            activity.startActivityForResult(intent, 1);
        });
    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

//    public LiveData<String> getText() {
//        return mText;
//    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView namatempat, lokasitempat, deskripsitempat;
        ImageView image;
        CardView tampilan_wisata;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            namatempat = itemView.findViewById(R.id.nama_tempat);
            deskripsitempat = itemView.findViewById(R.id.deskripsi_tempat);
            image = itemView.findViewById(R.id.gambar_tempat);
            lokasitempat = itemView.findViewById(R.id.lokasi_tempat);
            tampilan_wisata = itemView.findViewById(R.id.tampilan_wisata);
        }
    }
}