package com.example.baptc.ui.ui.croplist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baptc.Adapter.MyCropListAdapter;
import com.example.baptc.Common.Common;
import com.example.baptc.Model.CropModel;
import com.example.baptc.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CropListFragment extends Fragment {

    private CropListViewModel mViewModel;

    Unbinder unbinder;
    @BindView(R.id.recycler_crop_list)
    RecyclerView recycler_crop_list;

    LayoutAnimationController layoutAnimationController;
    MyCropListAdapter adapter;

    public static CropListFragment newInstance() {
        return new CropListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(CropListViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_crop_list, container, false);
        unbinder = ButterKnife.bind(this, root);
        initViews();
        mViewModel.getMutableLiveDataCropList().observe(this, new Observer<List<CropModel>>() {
            @Override
            public void onChanged(List<CropModel> cropModels) {
                adapter = new MyCropListAdapter(getContext(), cropModels);
                recycler_crop_list.setAdapter(adapter);
                recycler_crop_list.setLayoutAnimation(layoutAnimationController);
            }
        });
        return root;
    }

    private void initViews() {

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.categorySelected.getName());
        recycler_crop_list.setHasFixedSize(true);
        recycler_crop_list.setLayoutManager(new LinearLayoutManager(getContext()));

        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_item_from_left);

    }
}