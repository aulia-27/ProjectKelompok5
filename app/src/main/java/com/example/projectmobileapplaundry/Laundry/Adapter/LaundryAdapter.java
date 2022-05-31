package com.example.projectmobileapplaundry.Laundry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectmobileapplaundry.Laundry.Model.LaundryModel;
import com.example.projectmobileapplaundry.MainActivity.Adapter.MainAdapterRiwayatLaundry;
import com.example.projectmobileapplaundry.R;

import java.util.List;

public class LaundryAdapter extends RecyclerView.Adapter<LaundryAdapter.MainViewHolder> {

    Context context;
    private List<LaundryModel> laundryModels;
    public LaundryAdapter(Context context, List<LaundryModel> laundryModels) {
        this.context = context;
        this.laundryModels = laundryModels;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_laundry, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        LaundryModel laundryModel = laundryModels.get(position);
//        holder.id.setText(String.valueOf(userModel.getId()));
        Glide.with(context).load(laundryModel.getGambarItem()).into(holder.gambarItem);
        holder.txtNamaItem.setText(" " +laundryModel.getNamaItem());
        holder.txtHargaItem.setText(" " +laundryModel.getHargaItem());
    }

    @Override
    public int getItemCount() {
        return laundryModels.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder  {
        TextView txtIdItem, txtNamaItem, txtHargaItem, txtJumlahItem;
        ImageView gambarItem;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIdItem = itemView.findViewById(R.id.id_L);
            txtNamaItem = itemView.findViewById(R.id.txtNamaBarang_L);
            txtHargaItem = itemView.findViewById(R.id.txtHargaBarang_L);
            txtJumlahItem = itemView.findViewById(R.id.txtJumlahItem_L);
            gambarItem = itemView.findViewById(R.id.gambarBarang_L);
        }
    }
}
