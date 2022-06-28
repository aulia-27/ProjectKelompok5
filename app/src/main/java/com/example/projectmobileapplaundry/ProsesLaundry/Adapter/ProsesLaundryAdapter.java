package com.example.projectmobileapplaundry.ProsesLaundry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileapplaundry.ProsesLaundry.Model.ProsesLaundryModel;
import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.Riwayat.Adapter.RiwayatAdapter;
import com.example.projectmobileapplaundry.Riwayat.Model.RiwayatModel;

import java.util.List;

public class ProsesLaundryAdapter extends RecyclerView.Adapter<ProsesLaundryAdapter.ProsesLaundryViewHolder>{
    Context context;
    private List<ProsesLaundryModel> prosesLaundryModels;

    public ProsesLaundryAdapter(Context context, List<ProsesLaundryModel> prosesLaundryModels){
        this.context = context;
        this.prosesLaundryModels = prosesLaundryModels;
    }

    @NonNull
    @Override
    public ProsesLaundryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_proses_laundry,parent,false);
        ProsesLaundryViewHolder pvw  = new ProsesLaundryViewHolder(view);
        return pvw;
    }

    @Override
    public void onBindViewHolder(@NonNull ProsesLaundryViewHolder holder, int position) {
        ProsesLaundryModel prosesLaundryModel = prosesLaundryModels.get(position);
        holder.txtId_PL.setText(prosesLaundryModel.getId());
        holder.txtId_User_PL.setText(prosesLaundryModel.getId_user());
        holder.txtKodeAntrian_PL.setText(prosesLaundryModel.getKode_antrian());
        holder.txtJumlahItem_PL.setText(""+prosesLaundryModel.getJumlah_item_proses());
        holder.txtHargaTotal_PL.setText(""+prosesLaundryModel.getHarga_item_riwayat());
    }

    @Override
    public int getItemCount() {
        return prosesLaundryModels.size();
    }

    public class ProsesLaundryViewHolder extends RecyclerView.ViewHolder{
        TextView txtId_PL, txtId_User_PL, txtKodeAntrian_PL, txtJumlahItem_PL, txtHargaTotal_PL, txtStatus_PL;
        public ProsesLaundryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId_PL = itemView.findViewById(R.id.id_PL);
            txtId_User_PL = itemView.findViewById(R.id.id_user_PL);
            txtKodeAntrian_PL = itemView.findViewById(R.id.txtAntrian_RL);
            txtJumlahItem_PL = itemView.findViewById(R.id.txtJumlahItem_RL);
            txtHargaTotal_PL = itemView.findViewById(R.id.txtHargaTotal_PL);
            txtStatus_PL = itemView.findViewById(R.id.txtStatus_PL);

        }
    }
}
