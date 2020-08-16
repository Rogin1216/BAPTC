package com.example.baptc.Databases;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity(tableName = "Ship")
public class ShipItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cropId")
    private String cropId;

    @ColumnInfo(name = "cropName")
    private String cropName;

    @ColumnInfo(name = "cropImage")
    private String cropImage;

    @ColumnInfo(name = "cropPrice")
    private Double cropPrice;

    @ColumnInfo(name = "cropQuantity")
    private Double cropQuantity;

    @ColumnInfo(name = "userPhone")
    private String userPhone;

    @ColumnInfo(name = "uid")
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCropId() {
        return cropId;
    }

    public void setCropId(String cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropImage() {
        return cropImage;
    }

    public void setCropImage(String cropImage) {
        this.cropImage = cropImage;
    }

    public Double getCropPrice() {
        return cropPrice;
    }

    public void setCropPrice(Double cropPrice) {
        this.cropPrice = cropPrice;
    }

    public Double getCropQuantity() {
        return cropQuantity;
    }

    public void setCropQuantity(Double cropQuantity) {
        this.cropQuantity = cropQuantity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
