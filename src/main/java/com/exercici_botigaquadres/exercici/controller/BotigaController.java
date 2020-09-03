package com.exercici_botigaquadres.exercici.controller;

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
import java.util.Optional;

@RestController
@RequestMapping
public class BotigaController {
    @Autowired
    private IBotigaService botigaService;
    @Autowired
    private IPictureService pictureService;

    @GetMapping("/list")
    public ResponseEntity<List<ShopStore>> listarShopStore(Model model){
        List<ShopStore> shopStoreList= botigaService.findAll();

        if (shopStoreList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(shopStoreList);
        }
    }

    @PostMapping("insert")
    public ResponseEntity<ShopStore> insert(@Validated ShopStore shopStore, BindingResult result) throws Exception {
        if (result.hasErrors()) {
             throw new Exception("No puede haber campos vacios !" + shopStore.getIdStore());
        }
        botigaService.save(shopStore);
        return new ResponseEntity<ShopStore>(shopStore, HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ShopStore> actualizar(@Validated ShopStore shopStore){
        botigaService.save(shopStore);
        return  new ResponseEntity<ShopStore>(shopStore, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idStore}")
    public HttpStatus deleteStoreParaPostman(@PathVariable int idStore){
        botigaService.deleteById(idStore);
        return HttpStatus.OK;
    }
}
