package com.example.projectmobileapplaundry.MainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.model.ModelRiwayatLaundry;

import java.util.ArrayList;

public class MainAdapterRiwayatLaundry extends RecyclerView.Adapter<MainAdapterRiwayatLaundry.MainViewHolder> {

    ArrayList<ModelRiwayatLaundry> modelResultArrayList = new ArrayList<>();
    Context context;

    public MainAdapterRiwayatLaundry(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_riwayat_laundry,parent,false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ModelRiwayatLaundry modelRiwayatLaundry = modelResultArrayList.get(position);
        holder.txtAntrianRiwayat.setText(""+modelRiwayatLaundry.getId());
        holder.txtTanggalRiwayat.setText(""+modelRiwayatLaundry.getTanggal());
        holder.txtItemRiwayat.setText(""+modelRiwayatLaundry.getItem()+" Item");
        holder.txtHargaRiwayat.setText("Rp."+modelRiwayatLaundry.getHarga());
    }

    @Override
    public int getItemCount() {
        return modelResultArrayList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtAntrianRiwayat, txtTanggalRiwayat, txtItemRiwayat, txtHargaRiwayat;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAntrianRiwayat = itemView.findViewById(R.id.txtAntrianRiwayat);
            txtTanggalRiwayat = itemView.findViewById(R.id.txtTanggalRiwayat);
            txtItemRiwayat = itemView.findViewById(R.id.txtItemRiwayat);
            txtHargaRiwayat = itemView.findViewById(R.id.txtHargaTotalRiwayat);
        }
    }
}
