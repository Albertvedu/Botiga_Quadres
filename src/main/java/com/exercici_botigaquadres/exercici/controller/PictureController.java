package com.exercici_botigaquadres.exercici.controller;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.model.ShopStore;
import com.exercici_botigaquadres.exercici.service.IBotigaService;
import com.exercici_botigaquadres.exercici.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class PictureController {
    @Autowired
    private IPictureService pictureService;
    @Autowired
    IBotigaService botigaService;

    @GetMapping("/viewShopStore/{idStore}")
    public ResponseEntity<List<Picture>> viewShopStore(@PathVariable Integer idStore, Model model, ShopStore shopStore){
        List<Picture> pictureList= pictureService.findAllByIdStore(idStore);

        if (pictureList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pictureList);
        }
    }

    @PostMapping("insertPicture")
    public ResponseEntity<Picture> insertPicture(@Validated Picture picture, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("No puede haber campos vacios !" );
        }
        pictureService.save(picture);
        return new ResponseEntity<Picture>(picture, HttpStatus.OK);
    }
    @GetMapping("/editarPicture/{id}")
    public String editarPicture(@PathVariable Integer id, Model model){

        Picture picture = pictureService.findByIdPicture(id);

        return "editarPicture";
    }
    @PostMapping("/actualizarPicture")
    public ResponseEntity<Picture> actualizarPicture(@Validated Picture picture){
        pictureService.save(picture);
        return  new ResponseEntity<Picture>(picture, HttpStatus.OK);
    }
    @DeleteMapping("/deletePicture/{id}/{idStore}")
    public HttpStatus deletePicture(@PathVariable("id") int id, @PathVariable int idStore){
        pictureService.deleteById(id);
        return HttpStatus.OK;
    }
}
