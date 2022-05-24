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
    }

    @Override
    public int getItemCount() {
        return modelResultArrayList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtAntrian, txtTanggal, txtItem, txtHarga;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAntrian = itemView.findViewById(R.id.txtAntrianRiwayat);
            txtTanggal = itemView.findViewById(R.id.txtTanggalRiwayat);
            txtItem = itemView.findViewById(R.id.txtItemRiwayat);
            txtHarga = itemView.findViewById(R.id.txtHargaTotalRiwayat);
        }
    }
}
