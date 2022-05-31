package com.example.projectmobileapplaundry.DaftarHarga.Adapter;

import android.content.Context;
import android.text.PrecomputedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectmobileapplaundry.DaftarHarga.Model.DaftarHargaModel;
import com.example.projectmobileapplaundry.R;

import java.util.List;

public class DaftarHargaAdapter extends RecyclerView.Adapter<DaftarHargaAdapter.DaftarHargaHolder> {
    Context context;
    private List<DaftarHargaModel> daftarHargaModels;

    public DaftarHargaAdapter(Context context, List<DaftarHargaModel> daftarHargaModels){
        this.context = context;
        this.daftarHargaModels = daftarHargaModels;
    }

    @NonNull
    @Override
    public DaftarHargaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_harga_laundry,parent,false);
        DaftarHargaHolder dvh = new DaftarHargaHolder(view);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarHargaHolder holder, int position) {
        DaftarHargaModel daftarHargaModel = daftarHargaModels.get(position);
        holder.txtId_DH.setText(String.valueOf(daftarHargaModel.getId()));
        Glide.with(context).load(daftarHargaModel.getGambar_item()).into(holder.gambarItem_DH);
        holder.txtNamaItem_DH.setText(String.valueOf(daftarHargaModel.getHarga_item()));
        holder.txtJenisItem_DH.setText(String.valueOf(daftarHargaModel.getJenis_item()));
        holder.txtHargaItem_DH.setText(String.valueOf(daftarHargaModel.getHarga_item()));

    }

    @Override
    public int getItemCount() {
        return daftarHargaModels.size();
    }

    class DaftarHargaHolder extends RecyclerView.ViewHolder {
        TextView txtId_DH, txtNamaItem_DH, txtHargaItem_DH, txtJenisItem_DH;
        ImageView gambarItem_DH;
        public DaftarHargaHolder(@NonNull View itemView) {
            super(itemView);
            txtId_DH = itemView.findViewById(R.id.id_DH);
            txtNamaItem_DH = itemView.findViewById(R.id.txtNamaBarang_DH);
            txtJenisItem_DH  = itemView.findViewById(R.id.txtJenisItem_DH);
            txtHargaItem_DH = itemView.findViewById(R.id.txtHargaItem_DH);
            gambarItem_DH = itemView.findViewById(R.id.gambarItem_DH);
        }
    }
}
