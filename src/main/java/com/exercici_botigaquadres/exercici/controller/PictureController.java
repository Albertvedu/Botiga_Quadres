package com.exercici_botigaquadres.exercici.controller;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.model.ShopStore;
import com.exercici_botigaquadres.exercici.service.IBotigaService;
import com.exercici_botigaquadres.exercici.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
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

    @GetMapping("/viewShopStore/{idStore}")
    public String viewShopStore(@PathVariable Integer idStore, Model model, ShopStore shopStore){
        System.out.println("id de picture store: " + idStore);
        List<Picture> pictureList= pictureService.findAllByIdStore(idStore);
        model.addAttribute("viewStore", pictureList);
        model.addAttribute("idShopStore", idStore);
        //
         //model.addAttribute("picture_number", shopStore.getPicture_number());
        return "viewShopStore";
    }
    @GetMapping("/newPicture/{idStore}")
    public String newPicture(@PathVariable Integer idStore, Picture picture, Model model){
        verificarStock(idStore);
        model.addAttribute( "picture", new Picture());
        model.addAttribute("idShopStore", idStore);
        model.addAttribute("standardDate", picture.getDate());
        return "insertPicture";
    }
    @InitBinder
    public void miBinder(WebDataBinder binder){

        StringTrimmerEditor recortaEspacios = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, recortaEspacios);

    }
    @PostMapping("insertPicture")
    public String insertPicture(@Validated Picture picture, BindingResult result){
        if (result.hasErrors()) {
            return "insert";
        }
        pictureService.save(picture);
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

    void verificarStock(Integer idStore){
        ShopStore shopStore = botigaService.findByIdStore(idStore);
        if( shopStore.getPictureList().size() >= shopStore.getCapacity()) System.out.println("laerta");
    }
}
