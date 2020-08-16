package com.example.baptc.Databases;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class LocalShipDataSource implements ShipDataSource {


    private ShipDAO shipDAO;

    public LocalShipDataSource(ShipDAO shipDAO) {
        this.shipDAO = shipDAO;
    }



    @Override
    public Flowable<List<ShipItem>> getAllCart(String uid) {
        return shipDAO.getAllCart(uid);
    }

    @Override
    public Single<Integer> countItemInShip(String uid) {
        return shipDAO.countItemInShip(uid);
    }

    @Override
    public Single<Long> sumPriceInShip(String uid) {
        return shipDAO.sumPriceInShip(uid);
    }

    @Override
    public Single<ShipItem> getItemInShip(String uid, String cropId) {
        return shipDAO.getItemInShip(uid, cropId);
    }

    @Override
    public Completable insertOrReplaceAll(ShipItem... shipItems) {
        return shipDAO.insertOrReplaceAll(shipItems);
    }

    @Override
    public Single<Integer> updateShipItems(ShipItem shipItem) {
        return shipDAO.updateShipItems(shipItem);
    }

    @Override
    public Single<Integer> deleteShipItems(ShipItem shipItem) {
        return shipDAO.deleteShipItems(shipItem);
    }

    @Override
    public Single<Integer> cleanShip(String uid) {
        return shipDAO.cleanShip(uid);
    }
}
