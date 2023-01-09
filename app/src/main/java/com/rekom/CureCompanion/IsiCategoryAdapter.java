package com.rekom.CureCompanion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class IsiCategoryAdapter extends RecyclerView.Adapter<IsiCategoryAdapter.DynamicRVHolder>{

    public ArrayList<IsiCategoryRvModel> isiCategoryRvModels;

    public IsiCategoryAdapter(ArrayList<IsiCategoryRvModel> isiCategoryRvModels){
        this.isiCategoryRvModels = isiCategoryRvModels;
    }

    public class DynamicRVHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewObat;
        public TextView mObat, mHargaObat,mKategoriObat, mNetto, mDeksripsi;
        ConstraintLayout constraintLayout;

        public DynamicRVHolder(@NonNull View itemView) {
            super(itemView);
            imageViewObat = itemView.findViewById(R.id.iv_obat);
            mObat = itemView.findViewById(R.id.tv_obat);
            mHargaObat = itemView.findViewById(R.id.harga_obat);
//            mKategoriObat = itemView.findViewById(R.id.tv_kategori_obat);
            mNetto = itemView.findViewById(R.id.tv_netto);
            mDeksripsi = itemView.findViewById(R.id.tv_deksripsi);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

    @NonNull
    @Override
    public DynamicRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.isicategory_rv_item,parent,false);
        DynamicRVHolder dynamicRVHolder = new DynamicRVHolder(view);
        return dynamicRVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRVHolder holder, int position) {
        IsiCategoryRvModel currentItem = isiCategoryRvModels.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(currentItem.getImage())
                .into(holder.imageViewObat);

        holder.mObat.setText(currentItem.getNamaObat());
        holder.mHargaObat.setText(currentItem.getHargaObat());
//        holder.mKategoriObat.setText(currentItem.getKategoriObat());
        holder.mNetto.setText(currentItem.getNetto());
        holder.mDeksripsi.setText(currentItem.getDeksripsi());

    }

    @Override
    public int getItemCount() {
        return isiCategoryRvModels.size();
    }


}

