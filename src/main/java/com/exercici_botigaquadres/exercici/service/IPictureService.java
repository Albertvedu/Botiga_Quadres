package com.exercici_botigaquadres.exercici.service;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.repository.IPictureRepo;

import java.util.List;

public interface IPictureService extends IPictureRepo {
    List<Picture> findAllByIdStore(Integer idStore);
}
