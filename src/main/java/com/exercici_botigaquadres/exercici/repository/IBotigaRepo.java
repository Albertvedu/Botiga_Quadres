package com.exercici_botigaquadres.exercici.repository;

import com.exercici_botigaquadres.exercici.model.ShopStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  interface IBotigaRepo extends CrudRepository<ShopStore, Integer> {
    @Override
    List<ShopStore> findAll();


    public ShopStore findByIdStore(Integer integer) ;


}
