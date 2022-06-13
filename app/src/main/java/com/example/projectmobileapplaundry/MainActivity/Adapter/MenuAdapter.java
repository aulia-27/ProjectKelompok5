package com.example.projectmobileapplaundry.MainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmobileapplaundry.MainActivity.Model.MenuModel;
import com.example.projectmobileapplaundry.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private AdapterView.OnItemClickListener listener;
    List<MenuModel> menuList;
    Context context;

    public MenuAdapter(Context context, List<MenuModel> items) {
        this.context = context;
        this.menuList = items;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_menu,parent,false);
        return new MenuAdapter.MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuModel data = menuList.get(position);
        holder.imageMenu.setImageResource(data.getImageDrawable());
        holder.txtNamaMenu.setText(data.getTvTitle());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{
        public CardView cvMenu;
        public TextView txtNamaMenu;
        public ImageView imageMenu;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            cvMenu = itemView.findViewById(R.id.cvMenu);
            txtNamaMenu = itemView.findViewById(R.id.txtNamaMenu);
            imageMenu = itemView.findViewById(R.id.imageMenu);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(MenuModel modelMenu);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = (AdapterView.OnItemClickListener) listener;
    }
}
