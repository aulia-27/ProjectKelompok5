package com.example.projectmobileapplaundry.MainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.model.ModelProsesLaundry;

import java.util.ArrayList;

public class MainAdapterProsesLaundry extends RecyclerView.Adapter<MainAdapterProsesLaundry.MainViewHolder> {
    ArrayList<ModelProsesLaundry> modelResultArrayList = new ArrayList<>();
    Context context;

    public MainAdapterProsesLaundry(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_proses_laundry, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ModelProsesLaundry modelProsesLaundry = modelResultArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return modelResultArrayList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView txtAntrian, txtTanggal, txtItem, txtProses, txtHarga;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAntrian = itemView.findViewById(R.id.txtAntrian);
            txtTanggal = itemView.findViewById(R.id.txtTanggal);
            txtItem = itemView.findViewById(R.id.txtItem);
            txtProses = itemView.findViewById(R.id.txtProsesLaundry);
            txtHarga = itemView.findViewById(R.id.txtHargaTotal);
        }
    }
}
