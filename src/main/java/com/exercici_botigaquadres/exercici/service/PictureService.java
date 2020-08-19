package com.exercici_botigaquadres.exercici.service;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PictureService implements IPictureService{

    @Autowired
    PictureRepository repo;
    @Override
    public List<Picture> findAllByIdStore(Integer id){
        return repo.findAllByIdStore(id);
    }
    @Override
    public <S extends Picture> S save(S picture) {
        return repo.save(picture);
    }

    @Override
    public <S extends Picture> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Picture> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Picture> findAll() {
        return repo.findAll();
    }

    @Override
    public Iterable<Picture> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Picture picture) {

    }

    @Override
    public void deleteAll(Iterable<? extends Picture> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
