package com.example.baptc.Callback;

import com.example.baptc.Model.CategoryModel;

import java.util.List;

public interface ICategoryCallBackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryLoadFailed(String message);


}
