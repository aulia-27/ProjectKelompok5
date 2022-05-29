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
        holder.txtAntrianProses.setText(""+ prosesLaundryModel.getId());
        holder.txtTanggalProses.setText(""+ prosesLaundryModel.getTanggal());
        holder.txtItemProses.setText(""+ prosesLaundryModel.getItem());
        holder.txtProses.setText(""+ prosesLaundryModel.getStatus());
        holder.txtHargaProses.setText(""+ prosesLaundryModel.getHarga());
    }

    @Override
    public int getItemCount() {
        return mProsesLaundries.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtAntrianProses, txtTanggalProses, txtItemProses, txtProses, txtHargaProses;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAntrianProses = itemView.findViewById(R.id.txtAntrian);
            txtTanggalProses = itemView.findViewById(R.id.txtTanggal);
            txtItemProses = itemView.findViewById(R.id.txtItem);
            txtProses = itemView.findViewById(R.id.txtProsesLaundry);
            txtHargaProses = itemView.findViewById(R.id.txtHargaTotal);
        }
    }
}
