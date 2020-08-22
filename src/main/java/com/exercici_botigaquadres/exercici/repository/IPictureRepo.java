package com.exercici_botigaquadres.exercici.repository;

import com.exercici_botigaquadres.exercici.model.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPictureRepo extends CrudRepository<Picture, Integer> {

    Picture findByIdPicture(Integer id);

    @Override
    List<Picture> findAll();

    List<Picture> findAllByIdStore(Integer idStore);

}
