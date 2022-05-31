package com.example.projectmobileapplaundry.Riwayat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.Riwayat.Model.RiwayatModel;

import java.util.List;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder> {
    Context context;
    private List<RiwayatModel> riwayatModels;

    public RiwayatAdapter(Context context, List<RiwayatModel> riwayatModels){
        this.context = context;
        this.riwayatModels = riwayatModels;
    }

    @NonNull
    @Override
    public RiwayatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_riwayat_laundry,parent,false);
        RiwayatViewHolder rvw = new RiwayatViewHolder(view);
        return rvw;
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatViewHolder holder, int position) {
        RiwayatModel riwayatModel = riwayatModels.get(position);
        holder.txtId_RL.setText(riwayatModel.getId());
        holder.txtKodeAntrian_RL.setText(riwayatModel.getKode_antrian());
        holder.txtJumlahItem_RL.setText(""+riwayatModel.getJumlah_item_proses());
        holder.txtHargaTotal_RL.setText(""+riwayatModel.getHarga_item_riwayat());
        holder.txtStatus_RL.setText(riwayatModel.getStatus_riwayat());
    }

    @Override
    public int getItemCount() {
        return riwayatModels.size();
    }

    class RiwayatViewHolder extends RecyclerView.ViewHolder{
        TextView txtId_RL, txtKodeAntrian_RL, txtJumlahItem_RL, txtHargaTotal_RL, txtStatus_RL;
        public RiwayatViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId_RL = itemView.findViewById(R.id.id_R);
            txtKodeAntrian_RL = itemView.findViewById(R.id.txtAntrian_RL);
            txtJumlahItem_RL = itemView.findViewById(R.id.txtJumlahItem_RL);
            txtHargaTotal_RL = itemView.findViewById(R.id.txtHargaTotal_RL);
            txtStatus_RL = itemView.findViewById(R.id.txtStatus_RL);
        }
    }
}
