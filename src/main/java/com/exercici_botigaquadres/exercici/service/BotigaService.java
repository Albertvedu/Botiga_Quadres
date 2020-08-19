package com.exercici_botigaquadres.exercici.service;

import com.exercici_botigaquadres.exercici.model.ShopStore;
import com.exercici_botigaquadres.exercici.repository.IBotigaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public abstract class BotigaService implements IBotigaService{

    @Autowired
    private IBotigaRepo repo;

    @Override
    public <S extends ShopStore> S save(S shopStore) {
        return repo.save(shopStore);
    }

    @Override
    public <S extends ShopStore> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public ShopStore findByIdStore(Integer id) {
        return repo.findByIdStore(id);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<ShopStore> findAll() {
        return repo.findAll() ;
    }

    @Override
    public List<ShopStore> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(ShopStore shopStore) {

    }

    @Override
    public void deleteAll(Iterable<? extends ShopStore> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
