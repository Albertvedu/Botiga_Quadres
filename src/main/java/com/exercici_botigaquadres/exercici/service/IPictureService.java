package com.exercici_botigaquadres.exercici.service;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.repository.IPictureRepo;

import java.util.List;
import java.util.Optional;

public interface IPictureService extends IPictureRepo {
    List<Picture> findAllByIdStore(Integer idStore);
    Picture findByIdPicture (Integer id);

}
