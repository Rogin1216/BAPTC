package com.example.baptc.Databases;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface ShipDataSource {
    Flowable<List<ShipItem>> getAllCart(String uid);
    Single<Integer> countItemInShip(String uid);
    Single<Long> sumPriceInShip(String uid);
    Single<ShipItem> getItemInShip(String uid, String cropId);
    Completable insertOrReplaceAll(ShipItem... shipItems);
    Single<Integer> updateShipItems(ShipItem shipItem);
    Single<Integer> deleteShipItems(ShipItem shipItem);
    Single<Integer> cleanShip(String uid);
}
