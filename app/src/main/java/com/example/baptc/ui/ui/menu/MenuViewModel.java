package com.example.baptc.ui.ui.menu;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baptc.Callback.ICategoryCallBackListener;
import com.example.baptc.Common.Common;
import com.example.baptc.Model.CategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends ViewModel implements ICategoryCallBackListener {

    private MutableLiveData<List<CategoryModel>> categoryListMutable;
    private MutableLiveData<String> messageError = new MutableLiveData<>();
    private ICategoryCallBackListener categoryCallBackListener;

    public MenuViewModel(){
        categoryCallBackListener = this;

    }

    public MutableLiveData<List<CategoryModel>> getCategoryListMutable() {
        if(categoryListMutable == null) {
            categoryListMutable = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadCategories();
        }
        return categoryListMutable;
    }

    private void loadCategories() {
        final List<CategoryModel> templist = new ArrayList<>();
        DatabaseReference categoryRef = FirebaseDatabase.getInstance().getReference(Common.CATEGORY_REF);
        categoryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot itemSnapShot:snapshot.getChildren()){
                    CategoryModel categoryModel = itemSnapShot.getValue(CategoryModel.class);
                    categoryModel.setMenu_id(itemSnapShot.getKey());
                    templist.add(categoryModel);
                }
                categoryCallBackListener.onCategoryLoadSuccess(templist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                categoryCallBackListener.onCategoryLoadFailed(error.getMessage());

            }
        });
    }


    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onCategoryLoadSuccess(List<CategoryModel> categoryModelList) {
        categoryListMutable.setValue(categoryModelList);

    }

    @Override
    public void onCategoryLoadFailed(String message) {
        messageError.setValue(message);
    }
}