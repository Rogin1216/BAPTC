package com.example.baptc.Databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ShipDAO  {
    @Query("SELECT * FROM Ship WHERE uid=:uid")
    Flowable<List<ShipItem>> getAllCart(String uid);

    @Query("SELECT COUNT(*) FROM Ship WHERE uid=:uid")
    Single<Integer> countItemInShip(String uid);

    @Query("SELECT SUM(cropPrice*cropQuantity) FROM Ship WHERE uid=:uid")
    Single<Long> sumPriceInShip(String uid);

    @Query("SELECT * FROM Ship WHERE cropId=:cropId AND uid=:uid")
    Single<ShipItem> getItemInShip(String uid, String cropId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertOrReplaceAll(ShipItem... shipItems);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    Single<Integer> updateShipItems(ShipItem shipItem);

    @Delete
    Single<Integer> deleteShipItems(ShipItem shipItem);

    @Query("DELETE FROM Ship WHERE uid=:uid")
    Single<Integer> cleanShip(String uid);
}
