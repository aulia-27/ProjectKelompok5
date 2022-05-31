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
import com.example.projectmobileapplaundry.MainActivity.Model.ProsesLaundryModel;

import java.util.List;

public class MainAdapterProsesLaundry extends RecyclerView.Adapter<MainAdapterProsesLaundry.MainViewHolder> {
    Context context;
    private List<ProsesLaundryModel> mProsesLaundries;
    GridLayoutManager gridLayoutManager;

    public MainAdapterProsesLaundry(Context context, List<ProsesLaundryModel> mProsesLaundries){
        this.context = context;
        this.mProsesLaundries = mProsesLaundries;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_proses_laundry, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ProsesLaundryModel prosesLaundryModel = mProsesLaundries.get(position);
        holder.txtAntrianProses.setText(""+ prosesLaundryModel.getKode_antrian());
        holder.txtAntrianProses.setText(""+ prosesLaundryModel.getKode_antrian());
        holder.txtAntrianProses.setText(""+ prosesLaundryModel.getKode_antrian());
        holder.txtTanggalProses.setText(""+ prosesLaundryModel.getTanggal());
        holder.txtItemProses.setText(""+ prosesLaundryModel.getItem());
        holder.txtHargaProses.setText(""+ prosesLaundryModel.getHarga());
        holder.txtProses.setText(""+ prosesLaundryModel.getStatus());
    }

    @Override
    public int getItemCount() {
        return mProsesLaundries.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtId_PL, txtId_User_PL, txtAntrianProses, txtTanggalProses, txtItemProses, txtProses, txtHargaProses;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId_PL = itemView.findViewById(R.id.id_PL);
            txtId_User_PL = itemView.findViewById(R.id.id_user_PL);
            txtAntrianProses = itemView.findViewById(R.id.txtAntrian_PL);
            txtTanggalProses = itemView.findViewById(R.id.txtTanggal_PL);
            txtItemProses = itemView.findViewById(R.id.txtItem_PL);
            txtHargaProses = itemView.findViewById(R.id.txtHargaTotal_PL);
            txtProses = itemView.findViewById(R.id.txtStatus_PL);
        }
    }
}
