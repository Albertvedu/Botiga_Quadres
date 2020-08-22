package com.exercici_botigaquadres.exercici.repository;

import com.exercici_botigaquadres.exercici.model.Picture;

import java.util.List;
import java.util.Optional;

public class PictureRepository implements IPictureRepo{


    @Override
    public List<Picture> findAllByIdStore(Integer idStore) {
        return findAllByIdStore(idStore);
    }

    @Override
    public <S extends Picture> S save(S picture) {

        return save(picture);
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
    public Picture findByIdPicture(Integer id) {
        return findByIdPicture(id);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Picture> findAll() {
        List<Picture> picture = findAll();
        return picture;
    }

    @Override
    public Iterable<Picture> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        deleteById(id);
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
