package com.example.baptc.ui.ui.cropdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.andremion.counterfab.CounterFab;
import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.baptc.Common.Common;
import com.example.baptc.Model.CropModel;
import com.example.baptc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CropDetailFragment  extends Fragment {

    private CropDetailViewModel cropDetailViewModel;

    private Unbinder unbinder;

    @BindView(R.id.img_crop)
    ImageView img_crop;
    @BindView(R.id.btnTruck)
    CounterFab btnTruck;
    @BindView(R.id.crop_name)
    TextView crop_name;
    @BindView(R.id.crop_description)
    TextView crop_description;
    @BindView(R.id.crop_price)
    TextView crop_price;
    @BindView(R.id.number_button)
    ElegantNumberButton number_button;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cropDetailViewModel = ViewModelProviders.of(this).get(CropDetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crop_detail, container, false);
        unbinder = ButterKnife.bind(this, root);
        cropDetailViewModel.getMutableLiveDataCrop().observe(this, cropModel -> {
            displayInfo(cropModel);
        });
        return root;
    }

    private void displayInfo(CropModel cropModel) {
        Glide.with(getContext()).load(cropModel.getImage()).into(img_crop);
        crop_name.setText(new StringBuilder(cropModel.getName()));
        crop_description.setText(new StringBuilder(cropModel.getDescription()));
        crop_price.setText(new StringBuilder(cropModel.getPrice().toString()));

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.selectedCrop.getName());
    }
}
