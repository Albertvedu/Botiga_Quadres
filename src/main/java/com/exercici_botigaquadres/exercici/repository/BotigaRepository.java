package com.exercici_botigaquadres.exercici.repository;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.model.ShopStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class BotigaRepository implements IBotigaRepo{
    @Override
    public List<ShopStore> findAll() {
        List<ShopStore> shopStoreList = findAll();
        return shopStoreList;
    }

    @Override
    public Optional<ShopStore> findById(Integer id) {
        return findById(id);
    }

    @Override
    public ShopStore findByIdStore(Integer id){

        ShopStore shopStore = findByIdStore(id);
        return  shopStore;
    }

    @Override
    public <S extends ShopStore> S save(S shopStore) {

        return save(shopStore);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        deleteById(id);
    }
}
