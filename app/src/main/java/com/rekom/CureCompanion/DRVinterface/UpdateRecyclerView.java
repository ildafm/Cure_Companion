package com.rekom.CureCompanion.DRVinterface;

import com.rekom.CureCompanion.IsiCategoryRvModel;

import java.util.ArrayList;

public interface UpdateRecyclerView {
    public void callback(int position, ArrayList<IsiCategoryRvModel> items);
}
