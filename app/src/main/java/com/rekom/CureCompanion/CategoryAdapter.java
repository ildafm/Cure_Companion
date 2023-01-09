package com.rekom.CureCompanion;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rekom.CureCompanion.DRVinterface.UpdateRecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.StaticRVViewHolder>{

    private ArrayList<CategoryRvModel> items;
    int row_index = -1;
    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean select = true;

    public CategoryAdapter(ArrayList<CategoryRvModel> items, Activity activity, UpdateRecyclerView updateRecyclerView) {
        this.items = items;
        this.activity = activity;
        this.updateRecyclerView = updateRecyclerView;
    }

    public CategoryAdapter(ArrayList<CategoryRvModel> item) {
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_rv_item,parent, false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CategoryRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        if (check){

            ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
            items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
            updateRecyclerView.callback(position, items);
            check = false;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                //injeksi
                if(position==0){
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Bodrex", "1","Rp 20.000","sss","100ml","Obat Sakit Kepala", R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);

                }

                //kapsul
                else if(position==1){
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Bodrex", "1","Rp 6.900","kapsul","100g","Obat Sakit Kepala", R.drawable.kapsul));

                    items.add(new IsiCategoryRvModel("Diapet", "2","Rp 4.700","kapsul","15g","Diapet digunakan untuk membantu mengurangi frekuensi buang air besar. Tidak boleh diberikan pada anak dibawah 5 tahun dan penderita harus minum oralit.",R.drawable.kapsul));

                    items.add(new IsiCategoryRvModel("Ambeven", "3","Rp 16.000","kapsul","12g","Ambeven merupakan obat dengan kandungan herbal dalam bentuk kapsul. Obat ini digunakan untuk membantu meringankan gejala wasir. Membantu meringankan gejala wasir.",R.drawable.kapsul));

                    updateRecyclerView.callback(position, items);
                }

                //Krim
                else if(position==2) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);
                }

                //liquid
                else if(position==3) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);
                }

                //Obat Tetes
                else if(position==4) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);
                }

                //Salep
                else if(position==5) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);

                }

                //Serbuk
                else if(position==6) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);
                }

                //Sirup
                else if(position==7) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);
                }

                //Tablet
                else if(position==8) {

                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",R.drawable.kapsul));
                    updateRecyclerView.callback(position, items);

                }
            }
        });

        if(select){
            if(position==0)
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            select=false;
        }
        else{
            if (row_index == position){
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            }
            else {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);

            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_category);
            textView = itemView.findViewById(R.id.tv_item_category);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }
    }
}
