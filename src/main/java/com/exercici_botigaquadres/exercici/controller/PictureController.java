package com.exercici_botigaquadres.exercici.controller;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.model.ShopStore;
import com.exercici_botigaquadres.exercici.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class PictureController {
    @Autowired
    private IPictureService pictureService;

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
        model.addAttribute("standardDate", new Date());
        return "insertPicture";
    }
    @PostMapping("insertPicture")
    public String insert(@Validated Picture picture){
        pictureService.save(picture);
        return "redirect:/viewShopStore/" + picture.getIdStore();
    }
}
