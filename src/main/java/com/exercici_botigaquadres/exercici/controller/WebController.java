package com.exercici_botigaquadres.exercici.controller;

import com.exercici_botigaquadres.exercici.model.Picture;
import com.exercici_botigaquadres.exercici.model.ShopStore;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/listShopStore").setViewName("listShopStore");
       // registry.addViewController("/viewShopStore").setViewName("viewShopStore");
    }

    @GetMapping("/")
    public String showForm(ShopStore shopStore) {
        return "new";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Validated ShopStore shopStore, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new";
        }
        return "redirect:/listShopStore";
    }
//    @GetMapping("/b")
//    public String showForm(Picture picture) {
//        return "newPicture";
//    }
//
//    @PostMapping("/b")
//    public String checkPersonInfo(@Validated Picture picture, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "newPicture";
//        }
//        return "redirect:/viewShopStore/"+ picture.getIdStore();
//    }
}
