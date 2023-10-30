package com.smartcoach.smartcoachBackend.Business.admi.controllers;

import com.smartcoach.smartcoachBackend.Business.admi.entities.UbicacionxItem;
import com.smartcoach.smartcoachBackend.Business.admi.services.UbicacionxItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacionxitem")
public class UbicacionxItemController {

    @Autowired
    private UbicacionxItemService ubicacionxItemService;

    @GetMapping
    public List<UbicacionxItem> getAllUbicacionxItems() {
        return ubicacionxItemService.findAll();
    }

    @GetMapping("/{id}")
    public UbicacionxItem getUbicacionxItemById(@PathVariable Long id) {
        return ubicacionxItemService.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public UbicacionxItem addUbicacionxItem(@RequestBody UbicacionxItem ubicacionxItem) {
        return ubicacionxItemService.save(ubicacionxItem);
    }

    @PutMapping("/update")
    public UbicacionxItem updateUbicacionxItem(@RequestBody UbicacionxItem ubicacionxItem) {
        return ubicacionxItemService.save(ubicacionxItem);
    }

    @DeleteMapping("/{id}")
    public String deleteUbicacionxItem(@PathVariable Long id) {
        ubicacionxItemService.deleteById(id);
        return "UbicacionxItem id " + id + " deleted.";
    }

    @GetMapping("/getByItemId/{itemid}/{gimnasioid}")
    public List<UbicacionxItem> getUbicacionxItemsByItemId(@PathVariable int itemid,@PathVariable int gimnasioid) {
        List<UbicacionxItem> lista = ubicacionxItemService.getUbicacionxItemsByItemId(itemid);

        for(UbicacionxItem uxi : lista) {
            if (uxi.getGimnasioid() != gimnasioid) {
                lista.remove(uxi);
            }
        }
        return lista;
    }

    @GetMapping("/getByGimnasioId/{gimnasioid}")
    public List<UbicacionxItem> getUbicacionxItemsByGimnasioId(@PathVariable int gimnasioid) {
        List<UbicacionxItem> lista = ubicacionxItemService.getUbicacionxItemByGimnasioId(gimnasioid);
        return lista;
    }
}
