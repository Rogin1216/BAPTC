package com.example.baptc.ui.ui.cropdetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baptc.Common.Common;
import com.example.baptc.Model.CropModel;

public class CropDetailViewModel extends ViewModel {

    private MutableLiveData<CropModel> mutableLiveDataCrop;

    public CropDetailViewModel(){

    }

    public MutableLiveData<CropModel> getMutableLiveDataCrop() {
        if(mutableLiveDataCrop == null)
            mutableLiveDataCrop = new MutableLiveData<>();
        mutableLiveDataCrop.setValue(Common.selectedCrop);
        return mutableLiveDataCrop;
    }
}
