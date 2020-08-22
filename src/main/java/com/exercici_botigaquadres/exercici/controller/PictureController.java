package com.exercici_botigaquadres.exercici.controller;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.model.ShopStore;
import com.exercici_botigaquadres.exercici.service.IBotigaService;
import com.exercici_botigaquadres.exercici.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class PictureController {
    @Autowired
    private IPictureService pictureService;
    @Autowired
    IBotigaService botigaService;
    //@RequestMapping(path = "/viewShopStore/{shopStore}")
    //@RequestMapping(path = "/viewShopStore/{shopStore.getIdStore()}/{shopStore.getPictureList.get(shopStore.getIdStore())}")
    //@RequestMapping(path = "/viewShopStore/ shopStore", method = RequestMethod.GET)
    @GetMapping("/viewShopStore/{idStore}")
    public String viewShopStore(@PathVariable Integer idStore, Model model){
        System.out.println("id de picture store: " + idStore);
        List<Picture> pictureList= pictureService.findAllByIdStore(idStore);
        model.addAttribute("viewStore", pictureList);
        model.addAttribute("idShopStore", idStore);
        return "viewShopStore";
    }
    @GetMapping("/newPicture/{idStore}")
    public String newPicture(@PathVariable Integer idStore, Picture picture, Model model){
        model.addAttribute( "picture", new Picture());
        model.addAttribute("idShopStore", idStore);
        model.addAttribute("standardDate", picture.getDate());
        return "insertPicture";
    }
    @PostMapping("insertPicture")
    public String insertPicture(@Validated Picture picture){
        ShopStore shopStore = botigaService.findByIdStore(picture.getIdStore());
        shopStore.setPictureList(picture);
        pictureService.save(picture);
       botigaService.save(shopStore);
       // System.out.println("............................ "+shopStore.getPictureList().size());
        return "redirect:/viewShopStore/" + picture.getIdStore();
    }
    @GetMapping("/editarPicture/{id}")
    public String editarPicture(@PathVariable Integer id, Model model){

        Picture picture = pictureService.findByIdPicture(id);
        model.addAttribute("picture", picture);
        return "editarPicture";
    }
    @PostMapping("/actualizarPicture")
    public String actualizarPicture(@Validated Picture picture){
        pictureService.save(picture);
        return "redirect:/viewShopStore/" + picture.getIdStore();
    }
    @GetMapping("/deletePicture/{id}/{idStore}")
    public String deletePicture(@PathVariable("id") int id, @PathVariable int idStore){
        pictureService.deleteById(id);
        return "redirect:/viewShopStore/" + idStore;
    }
}
