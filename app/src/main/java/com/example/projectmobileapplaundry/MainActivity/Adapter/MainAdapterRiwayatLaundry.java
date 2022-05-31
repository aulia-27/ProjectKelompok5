package com.example.projectmobileapplaundry.MainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.MainActivity.Model.RiwayatLaundryModel;

import java.util.List;

public class MainAdapterRiwayatLaundry extends RecyclerView.Adapter<MainAdapterRiwayatLaundry.MainViewHolder> {

    Context context;
    private List<RiwayatLaundryModel> mRiwayatLaundries;
    GridLayoutManager gridLayoutManager;

    public MainAdapterRiwayatLaundry(Context context, List<RiwayatLaundryModel> mRiwayatLaundries){
        this.context = context;
        this.mRiwayatLaundries = mRiwayatLaundries;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_riwayat_laundry,parent,false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        RiwayatLaundryModel riwayatLaundryModel = mRiwayatLaundries.get(position);
        holder.txtId_rl.setText(""+riwayatLaundryModel.getId());
        holder.txtAntrianRiwayat.setText(""+ riwayatLaundryModel.getId());
        holder.txtTanggalRiwayat.setText(""+ riwayatLaundryModel.getTanggal());
        holder.txtItemRiwayat.setText(""+ riwayatLaundryModel.getItem()+" Item");
        holder.txtHargaRiwayat.setText("Rp."+ riwayatLaundryModel.getHarga());
    }

    @Override
    public int getItemCount() {
        return mRiwayatLaundries.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtId_rl, txtAntrianRiwayat, txtTanggalRiwayat, txtItemRiwayat, txtHargaRiwayat, txtStatusRiwayat;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId_rl = itemView.findViewById(R.id.id_PL);
            txtAntrianRiwayat = itemView.findViewById(R.id.txtAntrian_RL);
            txtTanggalRiwayat = itemView.findViewById(R.id.txtTanggal_RL);
            txtItemRiwayat = itemView.findViewById(R.id.txtJumlahItem_RL);
            txtHargaRiwayat = itemView.findViewById(R.id.txtHargaTotal_RL);
            txtStatusRiwayat = itemView.findViewById(R.id.txtStatus_RL);
        }
    }
}
