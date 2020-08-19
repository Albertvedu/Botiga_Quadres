package com.exercici_botigaquadres.exercici.repository;

import com.exercici_botigaquadres.exercici.model.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPictureRepo extends CrudRepository<Picture, Integer> {
    @Override
    List<Picture> findAll();

    List<Picture> findAllByIdStore(Integer idStore);


}
