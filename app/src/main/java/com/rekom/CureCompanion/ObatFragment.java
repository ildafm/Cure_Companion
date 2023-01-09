package com.rekom.CureCompanion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rekom.CureCompanion.DRVinterface.UpdateRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ObatFragment extends Fragment implements UpdateRecyclerView {

    private RecyclerView recyclerView, recyclerView2;
    private CategoryAdapter categoryAdapter;

    List<IsiCategoryRvModel> items = new ArrayList();
    IsiCategoryAdapter isicategoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.obat_fragment, container, false);

        final ArrayList<CategoryRvModel> item = new ArrayList<>();
        item.add(new CategoryRvModel(R.drawable.injeksi, "Injeksi"));
        item.add(new CategoryRvModel(R.drawable.kapsul, "Kapsul"));
        item.add(new CategoryRvModel(R.drawable.krim, "Krim"));
        item.add(new CategoryRvModel(R.drawable.obat_tetes, "Obat Tetes"));
        item.add(new CategoryRvModel(R.drawable.salep, "Salep"));
        item.add(new CategoryRvModel(R.drawable.serbuk, "Serbuk"));
        item.add(new CategoryRvModel(R.drawable.sirup, "Sirup"));
        item.add(new CategoryRvModel(R.drawable.tablet, "Tablet"));

        recyclerView = root.findViewById(R.id.rv_kategori);
        categoryAdapter = new CategoryAdapter(item, getActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(categoryAdapter);

        items = new ArrayList<>();

        recyclerView2 = root.findViewById(R.id.rv_obat);
        isicategoryAdapter = new IsiCategoryAdapter((ArrayList<IsiCategoryRvModel>) items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView2.setAdapter(isicategoryAdapter);

        items = new ArrayList<>();

        return root;

    }
    @Override
    public void callback(int position, ArrayList<IsiCategoryRvModel> items) {
        isicategoryAdapter = new IsiCategoryAdapter(items);
        isicategoryAdapter.notifyDataSetChanged();
        recyclerView2.setAdapter(isicategoryAdapter);

    }
}



