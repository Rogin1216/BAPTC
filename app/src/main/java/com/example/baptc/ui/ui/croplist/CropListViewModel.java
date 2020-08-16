package com.example.baptc.ui.ui.croplist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baptc.Common.Common;
import com.example.baptc.Model.CropModel;

import java.util.List;

public class CropListViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<CropModel>> mutableLiveDataCropList;
    public CropListViewModel() {
    }
    public MutableLiveData<List<CropModel>> getMutableLiveDataCropList() {
        if(mutableLiveDataCropList == null)
            mutableLiveDataCropList = new MutableLiveData<>();
        mutableLiveDataCropList.setValue(Common.categorySelected.getCrops());
        return mutableLiveDataCropList;
    }
}