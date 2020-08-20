package com.example.baptc.Common;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.example.baptc.Model.CategoryModel;
import com.example.baptc.Model.CropModel;

public class Common {
    public static final int DEFAULT_COLUMN_COUNT = 0;
    public static final int FULL_WIDTH_COLUMN = 1;
    public static final String CATEGORY_REF = "Category";
    public static CategoryModel categorySelected;
    public static CropModel selectedCrop;

    public static void setSpanString(String welcome, TextView textView) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(welcome);
        textView.setText(builder, TextView.BufferType.SPANNABLE);
    }
}